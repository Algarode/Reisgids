package com.smhtml.reisgids;

import com.smhtml.reisgids.Appuser;
import com.smhtml.reisgids.Userfoto;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-12T14:23:02")
@StaticMetamodel(Bezienswaardigheid.class)
public class Bezienswaardigheid_ { 

    public static volatile SingularAttribute<Bezienswaardigheid, Integer> id;
    public static volatile SingularAttribute<Bezienswaardigheid, String> long1;
    public static volatile CollectionAttribute<Bezienswaardigheid, Appuser> appuserCollection;
    public static volatile CollectionAttribute<Bezienswaardigheid, Userfoto> userfotoCollection;
    public static volatile SingularAttribute<Bezienswaardigheid, String> name;
    public static volatile SingularAttribute<Bezienswaardigheid, String> img;
    public static volatile SingularAttribute<Bezienswaardigheid, String> web;
    public static volatile SingularAttribute<Bezienswaardigheid, String> lat;

}