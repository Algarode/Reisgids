package com.smhtml.reisgids;

import com.smhtml.reisgids.Appuser;
import com.smhtml.reisgids.Bezienswaardigheid;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-12T14:23:02")
@StaticMetamodel(Userfoto.class)
public class Userfoto_ { 

    public static volatile SingularAttribute<Userfoto, Integer> id;
    public static volatile SingularAttribute<Userfoto, String> description;
    public static volatile SingularAttribute<Userfoto, Appuser> useremail;
    public static volatile SingularAttribute<Userfoto, String> image;
    public static volatile SingularAttribute<Userfoto, Bezienswaardigheid> bezienswaardigheidid;

}