angular.module('app.controllers', ['ionic', 'ngCordova'])

    .controller('bezienswaardighedenCtrl', function ($scope, $http, $cordovaGeolocation, $ionicLoading) {

        $ionicLoading.show({
         template: 'Bezienswaardigheden ophalen...'
         });

         var url = 'http://192.168.1.1:55072/Reisgids/webresources/com.smhtml.reisgids.bezienswaardigheid'

         $scope.getLocations = function() {
            $http.get(url).then(function(resp) {
            $scope.locations = resp.data
            var i = 0
         angular.forEach($scope.locations, function() {
            $scope.locations[i].distance = getDistanceFromLatLonInKm($scope.lat, $scope.long, $scope.locations[i]['lat'], $scope.locations[i]['long1'])
            i++
         });
         $ionicLoading.hide();
         }, function(err) {
            console.error('ERR', err);
            alert('Er ging iets fout' + err)
         })
         }

         var posOptions = { timeout: 10000, enableHighAccuracy: false };
         $cordovaGeolocation
         .getCurrentPosition(posOptions)
         .then(function(position) {
            $scope.lat  = position.coords.latitude
            $scope.long = position.coords.longitude
         $scope.getLocations()
         }, function(err) {
            // error
         });

         var watchOptions = {
         timeout : 3000,
         enableHighAccuracy: false
         };

         function getDistanceFromLatLonInKm(lat1, lon1, lat2, lon2) {
             var R = 6371; // Radius of the earth in km
             var dLat = deg2rad(lat2 - lat1);  // deg2rad below
             var dLon = deg2rad(lon2 - lon1);
             var a =
             Math.sin(dLat/2) * Math.sin(dLat/2) +
             Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
             Math.sin(dLon/2) * Math.sin(dLon/2);
             var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
             var d = R * c; // Distance in km
             return Math.round(d * 10) / 10; // Round to 1 decimal
         }

         function deg2rad(deg) {
            return deg * (Math.PI/180)
         }

    })

    .controller('loginCtrl', function ($scope, $state) {

        $scope.data = {};

        $scope.authenticate = function() {
            Parse.User.logIn($scope.data.email, $scope.data.password, {
                success: function (user) {
                    $state.go('bezienswaardigheden');
                }, error: function (user, error) {
                    alert('Er ging iets fout met het authenticeren van ' + user + ': ' + error.message);
                }
            });
        }

    })

    .controller('registrerenCtrl', function ($scope) {

        $scope.data = {};

        $scope.registerUser = function() {
            var user = new Parse.User();
            user.set("username", $scope.data.email);
            user.set("password", $scope.data.password);

            user.signUp(null, {
                success: function(user) {
                    alert('Registratie succesvol. U kunt nu inloggen')
                }, error: function(user, error) {
                    alert("Error: " + error.code + " " + error.message);
                }
            });
        }

    })

    .factory('Locations', function($http) {

        function getLocation(id, callback) {
            var url = 'http://192.168.1.1:55072/Reisgids/webresources/com.smhtml.reisgids.bezienswaardigheid/' + id;

            console.log('url defined')

            $http.get(url).success(function(data) {
                callback(data.results);
            });
        }

        return {
            list: getLocation,
            find: function(id, callback) {
                callback(id);
            }
        };

    })


    .controller('bezienswaardigheidCtrl', function ($scope, $http, $stateParams, $cordovaSocialSharing, $cordovaLaunchNavigator, $cordovaGeolocation, $ionicLoading, Locations) {

        $scope.getSelectedLocation = function() {
            var url = 'http://192.168.1.1:55072/Reisgids/webresources/com.smhtml.reisgids.bezienswaardigheid/' + $scope.locationid;
            $http.get(url).then(function(resp) {
                $scope.location = resp.data;
            }, function(err) {
                console.error('ERR', err);
                alert('Er ging iets fout' + err)
            });
        }

        Locations.find($stateParams.id, function(location) {
            $scope.locationid = location;
            $scope.getSelectedLocation();
        });

        $scope.addFavourite = function() {
            var url = 'http://192.168.1.1:55072/Reisgids/webresources/com.smhtml.reisgids.appuser/stefan@bogaard.nl/favbyid/';

            $http.defaults.headers.post['Content-Type'] = 'text/plain';
            $http.post(url, $scope.location.id).success(function(resp) {
                console.log('success');
            }).error(function(resp) {
                console.log('error: ' + resp);
            });
        }

        $scope.share = function() {
            $cordovaSocialSharing
                .shareViaFacebook('Prachtige locatie: ' + $scope.location.web, $scope.location.img, $scope.location.web)
                .then(function(result) {
                    console.log("success: " + result)
                }, function(err) {
                    console.log("error: " + err)
                });
        }

        $ionicLoading.show({
            template: 'Huidige positie bepalen...'
        });

        var posOptions = { timeout: 10000, enableHighAccuracy: false };
        $cordovaGeolocation
            .getCurrentPosition(posOptions)
            .then(function(position) {
                $scope.lat  = position.coords.latitude;
                $scope.long = position.coords.longitude;
                $ionicLoading.hide();
            }, function(err) {
                $ionicLoading.hide();
            });

        $scope.startNavigation = function() {
            var destination = [$scope.location.lat, $scope.location.long1];
            var start = [$scope.lat, $scope.long];
            $cordovaLaunchNavigator.navigate(destination, start).then(function() {
            }, function(err) {
                console.error(err);
            });
        }

    })

    .controller('fotoDetailsCtrl', function ($scope, $http, $cordovaCamera) {

        $scope.baseUrl = 'http://192.168.1.1:55072/Reisgids/webresources/com.smhtml.reisgids.';

        var url = $scope.baseUrl + 'file/upload/stefan@bogaard.nl';

        $scope.takePhoto = function () {
            var options = {
                quality: 75,
                destinationType: Camera.DestinationType.DATA_URL,
                sourceType: Camera.PictureSourceType.CAMERA,
                allowEdit: true,
                encodingType: Camera.EncodingType.JPEG,
                targetWidth: 300,
                targetHeight: 300,
                popoverOptions: CameraPopoverOptions,
                saveToPhotoAlbum: false
            };

            $cordovaCamera.getPicture(options).then(function (imageData) {
                $scope.lastPhoto = imageData;
                $scope.imgURI = "data:image/jpeg;base64," + imageData;
                //console.log($scope.imgURI)
            }, function (err) {
                alert('Er ging iets fout: ' + err)
            });
        }

        /*$scope.uploadImage = function() {
            if ($scope.lastPhoto != null) {
                var dataToSubmit = { base64: $scope.lastPhoto }
                console.log(url)
                $http.post(url, dataToSubmit).then(function (resp) {
                    console.log('in de post')
                    $scope.response = resp.data
                    console.log(resp.data)
                });
            } else {
                alert('Er is geen afbeelding om te uploaden')
            }
        }*/

        $scope.uploadPhoto = function(){

            var post = Parse.Object.extend("post");
            var newPost = new post();

            // Creates parse file object you'll notice that you have to convert
            // $scope.imageData to a base 64 object.
            var parseFile = new Parse.File('mypic.jpeg',{base64:$scope.imageData});
            var description = "image upload test no pic";
            var title = 'image no pic';

            newPost.set("title", title);
            newPost.set("description", description);
            newPost.set("image",parseFile);
            newPost.save(null, {

                success: function () {
                    // do whatever
                    console.log('success')
                },
                error: function (error) {
                    // do whatever
                    console.log(error)
                }
            }
            )}

    })