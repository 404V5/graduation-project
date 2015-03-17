


--
-- Dumping data for table t_baoxianfuli
--

LOCK TABLES  t_baoxianfuli  WRITE;
/*!40000 ALTER TABLE  t_baoxianfuli  DISABLE KEYS */;

/*!40000 ALTER TABLE  t_baoxianfuli  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Source for table t_bumen
--

DROP TABLE IF EXISTS  t_bumen ;
CREATE TABLE  t_bumen  (
   id  bigint(20) NOT NULL auto_increment,
   bumenlock  int(11) NOT NULL,
   name  varchar(255) default NULL,
  PRIMARY KEY  ( id )
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Dumping data for table t_bumen
--

LOCK TABLES  t_bumen  WRITE;
/*!40000 ALTER TABLE  t_bumen  DISABLE KEYS */;

/*!40000 ALTER TABLE  t_bumen  ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_gongzi
#

DROP TABLE IF EXISTS  t_gongzi ;
CREATE TABLE  t_gongzi  (
   id  bigint(20) NOT NULL auto_increment,
   createtime  datetime default NULL,
   gongzi  varchar(255) default NULL,
   gongzilock  int(11) NOT NULL,
   yuefen  varchar(255) default NULL,
   yuangongid  bigint(20) default NULL,
  PRIMARY KEY  ( id ),
  KEY  FK32F029DB4415F239  ( yuangongid )
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_gongzi
#

LOCK TABLES  t_gongzi  WRITE;
/*!40000 ALTER TABLE  t_gongzi  DISABLE KEYS */;

/*!40000 ALTER TABLE  t_gongzi  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Source for table t_hetong
--

DROP TABLE IF EXISTS  t_hetong ;
CREATE TABLE  t_hetong  (
   id  bigint(20) NOT NULL auto_increment,
   beizhu  varchar(255) default NULL,
   createtime  datetime default NULL,
   hetonglock  int(11) NOT NULL,
   path  varchar(255) default NULL,
   yuangongid  bigint(20) default NULL,
  PRIMARY KEY  ( id ),
  KEY  FK341AEE3C4415F239  ( yuangongid )
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Dumping data for table t_hetong
--

LOCK TABLES  t_hetong  WRITE;
/*!40000 ALTER TABLE  t_hetong  DISABLE KEYS */;

/*!40000 ALTER TABLE  t_hetong  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Source for table t_kaoqin
--

DROP TABLE IF EXISTS  t_kaoqin ;
CREATE TABLE  t_kaoqin  (
   id  bigint(20) NOT NULL auto_increment,
   beizhu  varchar(255) default NULL,
   createtime  datetime default NULL,
   kaoqinlock  int(11) NOT NULL,
   leixing  varchar(255) default NULL,
   yuangongid  bigint(20) default NULL,
  PRIMARY KEY  ( id ),
  KEY  FK38FEDB284415F239  ( yuangongid )
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table t_kaoqin
--

LOCK TABLES  t_kaoqin  WRITE;
/*!40000 ALTER TABLE  t_kaoqin  DISABLE KEYS */;

/*!40000 ALTER TABLE  t_kaoqin  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Source for table t_peixun
--

DROP TABLE IF EXISTS  t_peixun ;
CREATE TABLE  t_peixun  (
   id  bigint(20) NOT NULL auto_increment,
   createtime  datetime default NULL,
   peixundidian  varchar(255) default NULL,
   peixunjihua  varchar(255) default NULL,
   peixunlock  int(11) NOT NULL,
   peixunneirong  varchar(255) default NULL,
   peixunzhouqi  varchar(255) default NULL,
   yuangongid  bigint(20) default NULL,
  PRIMARY KEY  ( id ),
  KEY  FK41BCD5C84415F239  ( yuangongid )
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table t_peixun
--

LOCK TABLES  t_peixun  WRITE;
/*!40000 ALTER TABLE  t_peixun  DISABLE KEYS */;

/*!40000 ALTER TABLE  t_peixun  ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_user
#

DROP TABLE IF EXISTS  t_user ;
CREATE TABLE  t_user  (
   id  bigint(20) NOT NULL auto_increment,
   createtime  datetime default NULL,
   password  varchar(255) default NULL,
   role  int(11) NOT NULL,
   truename  varchar(255) default NULL,
   userlock  int(11) NOT NULL,
   username  varchar(255) default NULL,
   yuangongid  bigint(20) default NULL,
  PRIMARY KEY  ( id ),
  KEY  FKCB5540D64415F239  ( yuangongid )
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_user
#

LOCK TABLES  t_user  WRITE;
/*!40000 ALTER TABLE  t_user  DISABLE KEYS */;


/*!40000 ALTER TABLE  t_user  ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_yuangong
#

DROP TABLE IF EXISTS  t_yuangong ;
CREATE TABLE  t_yuangong  (
   id  bigint(20) NOT NULL auto_increment,
   beizhu  varchar(255) default NULL,
   createtime  datetime default NULL,
   dizhi  varchar(255) default NULL,
   jiguan  varchar(255) default NULL,
   lianxidianhua  varchar(255) default NULL,
   ruzhishijian  varchar(255) default NULL,
   truename  varchar(255) default NULL,
   xingbie  varchar(255) default NULL,
   xueli  varchar(255) default NULL,
   yuangonghao  varchar(255) default NULL,
   yuangonglock  int(11) NOT NULL,
   zhiwu  int(11) NOT NULL,
   bumenid  bigint(20) default NULL,
  PRIMARY KEY  ( id ),
  KEY  FKACF2CFF5EA5F3717  ( bumenid )
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_yuangong
#

LOCK TABLES  t_yuangong  WRITE;
/*!40000 ALTER TABLE  t_yuangong  DISABLE KEYS */;

/*!40000 ALTER TABLE  t_yuangong  ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_zhiwei
#

DROP TABLE IF EXISTS  t_zhiwei ;
CREATE TABLE  t_zhiwei  (
   id  bigint(20) NOT NULL auto_increment,
   beizhu  varchar(255) default NULL,
   createtime  datetime default NULL,
   zhaopinrenshi  varchar(255) default NULL,
   zhiweilock  int(11) NOT NULL,
   zhiweimingchen  varchar(255) default NULL,
  PRIMARY KEY  ( id )
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_zhiwei
#

LOCK TABLES  t_zhiwei  WRITE;
/*!40000 ALTER TABLE  t_zhiwei  DISABLE KEYS */;

/*!40000 ALTER TABLE  t_zhiwei  ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_zhiweijilu
#

DROP TABLE IF EXISTS  t_zhiweijilu ;
CREATE TABLE  t_zhiweijilu  (
   id  bigint(20) NOT NULL auto_increment,
   addresss  varchar(255) default NULL,
   createtime  datetime default NULL,
   lianxidianhua  varchar(255) default NULL,
   xingbie  varchar(255) default NULL,
   xingming  varchar(255) default NULL,
   xueli  varchar(255) default NULL,
   yingpingjieguo  varchar(255) default NULL,
   zhiweijilulock  int(11) NOT NULL,
   zhiweiid  bigint(20) default NULL,
  PRIMARY KEY  ( id ),
  KEY  FKBFAFF65391549B65  ( zhiweiid )
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_zhiweijilu
#

LOCK TABLES  t_zhiweijilu  WRITE;
/*!40000 ALTER TABLE  t_zhiweijilu  DISABLE KEYS */;

/*!40000 ALTER TABLE  t_zhiweijilu  ENABLE KEYS */;
UNLOCK TABLES;

#
#  Foreign keys for table t_baoxianfuli
#

ALTER TABLE  t_baoxianfuli 
ADD CONSTRAINT  FK3A810B0F4415F239  FOREIGN KEY ( yuangongid ) REFERENCES  t_yuangong  ( id );

#
#  Foreign keys for table t_gongzi
#

ALTER TABLE  t_gongzi 
ADD CONSTRAINT  FK32F029DB4415F239  FOREIGN KEY ( yuangongid ) REFERENCES  t_yuangong  ( id );

#
#  Foreign keys for table t_hetong
#

ALTER TABLE  t_hetong 
ADD CONSTRAINT  FK341AEE3C4415F239  FOREIGN KEY ( yuangongid ) REFERENCES  t_yuangong  ( id );

#
#  Foreign keys for table t_kaoqin
#

ALTER TABLE  t_kaoqin 
ADD CONSTRAINT  FK38FEDB284415F239  FOREIGN KEY ( yuangongid ) REFERENCES  t_yuangong  ( id );

#
#  Foreign keys for table t_peixun
#

ALTER TABLE  t_peixun 
ADD CONSTRAINT  FK41BCD5C84415F239  FOREIGN KEY ( yuangongid ) REFERENCES  t_yuangong  ( id );

#
#  Foreign keys for table t_user
#

ALTER TABLE  t_user 
ADD CONSTRAINT  FKCB5540D64415F239  FOREIGN KEY ( yuangongid ) REFERENCES  t_yuangong  ( id );

#
#  Foreign keys for table t_yuangong
#

ALTER TABLE  t_yuangong 
ADD CONSTRAINT  FKACF2CFF5EA5F3717  FOREIGN KEY ( bumenid ) REFERENCES  t_bumen  ( id );

#
#  Foreign keys for table t_zhiweijilu
#

ALTER TABLE  t_zhiweijilu 
ADD CONSTRAINT  FKBFAFF65391549B65  FOREIGN KEY ( zhiweiid ) REFERENCES  t_zhiwei  ( id );



