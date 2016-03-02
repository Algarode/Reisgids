package com.smhtml.reisgids;

import com.smhtml.reisgids.Bezienswaardigheid;
import com.smhtml.reisgids.Userfoto;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-12T14:23:02")
@StaticMetamodel(Appuser.class)
public class Appuser_ { 

    public static volatile CollectionAttribute<Appuser, Bezienswaardigheid> bezienswaardigheidCollection;
    public static volatile CollectionAttribute<Appuser, Userfoto> userfotoCollection;
    public static volatile SingularAttribute<Appuser, String> email;
    public static volatile SingularAttribute<Appuser, String> password;

}