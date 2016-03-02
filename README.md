# Reisgids

Een klein project waarmee bezienswaardigheden kunnen worden bekeken aan de hand van GPS.
Backend gemaakt met Java EE, frontend gemaakt met ionic.

# JAVA WS

## User
     
*	**Find all users** http://localhost:55072/Reisgids/webresources/com.smhtml.reisgids.appuser ---- GET 
*	**Find user by id** http://localhost:55072/Reisgids/webresources/com.smhtml.reisgids.appuser/stefan@bogaard.nl ---- GET 
*	**Count users** http://localhost:55072/Reisgids/webresources/com.smhtml.reisgids.appuser/count ---- GET 
*	**add user ** http://localhost:55072/Reisgids/webresources/com.smhtml.reisgids.appuser/  ---  POST; Content-Type: application/json; payload exmaple: {"email":"ali@baba","password":"123"} 
*	**delete user ** http://localhost:55072/Reisgids/webresources/com.smhtml.reisgids.appuser/ali@baba.nl ---- DELETE; Content-Type: application/json; payload example {"email":"ali@baba","password":"123"} 
*	**delete user ** http://localhost:55072/Reisgids/webresources/com.smhtml.reisgids.appuser/ali@baba.nl ---- PUT; Content-Type: application/json; payload example {"email":"ali@baba","password":"123"} 
*	**get user favorites** http://localhost:55072/Reisgids/webresources/com.smhtml.reisgids.appuser/stefan@bogaard.nl/fav ---- GET
*	**post user favorite** http://localhost:55072/Reisgids/webresources/com.smhtml.reisgids.appuser/stefan@bogaard.nl/fav ---- POST; Content-Type: application/json; payload example {"id":0,"img":"http://starfish-it.nl/assets/img/android-logo.png","lat":"51.4389713","long1":"5.477495","name":"muziekcentrum","web":"https://www.muziekgebouweindhoven.nl/"}
    

## Bezienswaardigheden

*	**Find all bezienswaardigheden** http://localhost:55072/Reisgids/webresources/com.smhtml.reisgids.bezienswaardigheid ---- GET
*	**Find bezienswaardigheid by id** http://localhost:55072/Reisgids/webresources/com.smhtml.reisgids.bezienswaardigheid/0 ---- GET
*	**Count bezienswaardigheden ** http://localhost:55072/Reisgids/webresources/com.smhtml.reisgids.bezienswaardigheid/count ---- GET
*	**Post bezienswaardigheid ** http://localhost:55072/Reisgids/webresources/com.smhtml.reisgids.bezienswaardigheid/ ---- POST; Content-Type : application/json; payload example {"id":11,"img":"http://starfish-it.nl/assets/img/android-logo.png","lat":"51.4389713","long1":"5.477495","name":"muziekcentrum2","web":"https://www.muziekgebouweindhoven.nl/"}

## Files
*	**Post file ** http://localhost:55072/Reisgids/webresources/com.smhtml.reisgids.file/upload/stefan@bogaard.nl ---- POST; zie index.html
*	**Retrieve file ** http://localhost:55072/Reisgids/webresources/com.smhtml.reisgids.file/download/stefan@bogaard.nl/AAAA.jpg ---- GET
