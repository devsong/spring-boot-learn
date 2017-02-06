package com.gzs.learn.boot.jpa.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TestHb.class)
public abstract class TestHb_ {

	public static volatile SingularAttribute<TestHb, String> address;
	public static volatile SingularAttribute<TestHb, String> phone;
	public static volatile SingularAttribute<TestHb, Date> createTime;
	public static volatile SingularAttribute<TestHb, String> name;
	public static volatile SingularAttribute<TestHb, Date> updateTime;
	public static volatile SingularAttribute<TestHb, Integer> id;
	public static volatile SingularAttribute<TestHb, Integer> age;

}

