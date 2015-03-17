SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tb_link]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[tb_link](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[linkName] [varchar](50) NULL,
	[linkAddress] [varchar](53) NULL,
	[linkPicture] [varchar](51) NULL,
	[linkTime] [smalldatetime] NULL
) ON [PRIMARY]
END
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_link', N'COLUMN',N'id'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'数据库流水号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_link', @level2type=N'COLUMN',@level2name=N'id'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_link', N'COLUMN',N'linkName'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'接连网站的名称' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_link', @level2type=N'COLUMN',@level2name=N'linkName'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_link', N'COLUMN',N'linkAddress'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'网站连接地址' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_link', @level2type=N'COLUMN',@level2name=N'linkAddress'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_link', N'COLUMN',N'linkPicture'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'网站连接图片的地址' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_link', @level2type=N'COLUMN',@level2name=N'linkPicture'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_link', N'COLUMN',N'linkTime'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'创建的时间' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_link', @level2type=N'COLUMN',@level2name=N'linkTime'
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tb_manager]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[tb_manager](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[account] [varchar](51) NULL,
	[password] [varchar](50) NULL,
	[name] [varchar](53) NULL,
	[sign] [bit] NULL
) ON [PRIMARY]
END
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_manager', N'COLUMN',N'id'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'数据库流水号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_manager', @level2type=N'COLUMN',@level2name=N'id'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_manager', N'COLUMN',N'account'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'管理员帐号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_manager', @level2type=N'COLUMN',@level2name=N'account'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_manager', N'COLUMN',N'password'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'管理员密码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_manager', @level2type=N'COLUMN',@level2name=N'password'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_manager', N'COLUMN',N'name'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'管理员姓名' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_manager', @level2type=N'COLUMN',@level2name=N'name'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_manager', N'COLUMN',N'sign'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'总管理员标识（0:是、1:否）' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_manager', @level2type=N'COLUMN',@level2name=N'sign'
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tb_member]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[tb_member](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](52) NULL,
	[password] [varchar](50) NULL,
	[reallyName] [varchar](10) NULL,
	[age] [int] NULL,
	[profession] [varchar](50) NULL,
	[email] [varchar](50) NULL,
	[question] [varchar](50) NULL,
	[result] [varchar](51) NULL
) ON [PRIMARY]
END
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_member', N'COLUMN',N'id'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'数据库流水号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_member', @level2type=N'COLUMN',@level2name=N'id'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_member', N'COLUMN',N'name'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'会员名称' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_member', @level2type=N'COLUMN',@level2name=N'name'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_member', N'COLUMN',N'password'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'会员密码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_member', @level2type=N'COLUMN',@level2name=N'password'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_member', N'COLUMN',N'reallyName'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'会员真实姓名' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_member', @level2type=N'COLUMN',@level2name=N'reallyName'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_member', N'COLUMN',N'age'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'会员年龄' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_member', @level2type=N'COLUMN',@level2name=N'age'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_member', N'COLUMN',N'profession'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'会员职业' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_member', @level2type=N'COLUMN',@level2name=N'profession'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_member', N'COLUMN',N'email'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'电子邮件地址' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_member', @level2type=N'COLUMN',@level2name=N'email'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_member', N'COLUMN',N'question'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'找回密码的问题' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_member', @level2type=N'COLUMN',@level2name=N'question'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_member', N'COLUMN',N'result'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'找回密码的答案' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_member', @level2type=N'COLUMN',@level2name=N'result'
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tb_order]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[tb_order](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[number] [varchar](54) NOT NULL,
	[name] [varchar](50) NULL,
	[reallyName] [varchar](50) NULL,
	[address] [varchar](50) NULL,
	[tel] [varchar](50) NULL,
	[setMoney] [varchar](51) NULL,
	[post] [varchar](51) NULL,
	[bz] [text] NULL,
	[sign] [bit] NULL,
	[creaTime] [smalldatetime] NULL,
 CONSTRAINT [PK_tb_order] PRIMARY KEY CLUSTERED 
(
	[number] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
END
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_order', N'COLUMN',N'id'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'数据库流水号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_order', @level2type=N'COLUMN',@level2name=N'id'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_order', N'COLUMN',N'number'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'订单编号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_order', @level2type=N'COLUMN',@level2name=N'number'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_order', N'COLUMN',N'name'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'会员名称' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_order', @level2type=N'COLUMN',@level2name=N'name'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_order', N'COLUMN',N'reallyName'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'真实姓名' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_order', @level2type=N'COLUMN',@level2name=N'reallyName'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_order', N'COLUMN',N'address'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'送货地址' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_order', @level2type=N'COLUMN',@level2name=N'address'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_order', N'COLUMN',N'tel'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'联系电话' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_order', @level2type=N'COLUMN',@level2name=N'tel'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_order', N'COLUMN',N'setMoney'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'付款方式' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_order', @level2type=N'COLUMN',@level2name=N'setMoney'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_order', N'COLUMN',N'post'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'运送方式' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_order', @level2type=N'COLUMN',@level2name=N'post'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_order', N'COLUMN',N'bz'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'备注信息' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_order', @level2type=N'COLUMN',@level2name=N'bz'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_order', N'COLUMN',N'creaTime'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'创建时间' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_order', @level2type=N'COLUMN',@level2name=N'creaTime'
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tb_affiche]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[tb_affiche](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](53) NULL,
	[content] [text] NULL,
	[issueTime] [smalldatetime] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
END
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_affiche', N'COLUMN',N'id'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'数据库流水号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_affiche', @level2type=N'COLUMN',@level2name=N'id'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_affiche', N'COLUMN',N'name'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'公告标题' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_affiche', @level2type=N'COLUMN',@level2name=N'name'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_affiche', N'COLUMN',N'content'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'公告内容' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_affiche', @level2type=N'COLUMN',@level2name=N'content'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_affiche', N'COLUMN',N'issueTime'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'公告发布时间' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_affiche', @level2type=N'COLUMN',@level2name=N'issueTime'
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tb_bigType]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[tb_bigType](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[bigName] [varchar](53) NULL,
	[creaTime] [smalldatetime] NULL,
 CONSTRAINT [PK_tb_bigType] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_bigType', N'COLUMN',N'id'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'数据库流水号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_bigType', @level2type=N'COLUMN',@level2name=N'id'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_bigType', N'COLUMN',N'bigName'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'大类别的名称' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_bigType', @level2type=N'COLUMN',@level2name=N'bigName'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_bigType', N'COLUMN',N'creaTime'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'创建时间' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_bigType', @level2type=N'COLUMN',@level2name=N'creaTime'
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tb_goods]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[tb_goods](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[bigId] [int] NOT NULL,
	[smallId] [int] NOT NULL,
	[goodsName] [varchar](51) NULL,
	[goodsFrom] [varchar](53) NULL,
	[introduce] [text] NULL,
	[creaTime] [smalldatetime] NULL,
	[nowPrice] [money] NULL,
	[freePrice] [money] NULL,
	[number] [int] NULL,
	[pirture] [varchar](50) NULL,
	[mark] [bit] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
END
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_goods', N'COLUMN',N'id'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'数据库流水号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_goods', @level2type=N'COLUMN',@level2name=N'id'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_goods', N'COLUMN',N'bigId'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'大类别的编号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_goods', @level2type=N'COLUMN',@level2name=N'bigId'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_goods', N'COLUMN',N'smallId'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'小类别的编号（小类别表的外键）' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_goods', @level2type=N'COLUMN',@level2name=N'smallId'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_goods', N'COLUMN',N'goodsName'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'产品的名称' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_goods', @level2type=N'COLUMN',@level2name=N'goodsName'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_goods', N'COLUMN',N'goodsFrom'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'产品的生产厂商' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_goods', @level2type=N'COLUMN',@level2name=N'goodsFrom'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_goods', N'COLUMN',N'introduce'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'产品的定价' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_goods', @level2type=N'COLUMN',@level2name=N'introduce'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_goods', N'COLUMN',N'creaTime'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'产品添加的时间' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_goods', @level2type=N'COLUMN',@level2name=N'creaTime'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_goods', N'COLUMN',N'nowPrice'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'产品的现价' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_goods', @level2type=N'COLUMN',@level2name=N'nowPrice'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_goods', N'COLUMN',N'freePrice'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'产品的特价价格' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_goods', @level2type=N'COLUMN',@level2name=N'freePrice'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_goods', N'COLUMN',N'number'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'购买次数' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_goods', @level2type=N'COLUMN',@level2name=N'number'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_goods', N'COLUMN',N'pirture'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'商品图片地址' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_goods', @level2type=N'COLUMN',@level2name=N'pirture'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_goods', N'COLUMN',N'mark'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'是否是特价商品' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_goods', @level2type=N'COLUMN',@level2name=N'mark'
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tb_smallType]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[tb_smallType](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[bigId] [int] NOT NULL,
	[smallName] [varchar](53) NULL,
	[creaTime] [smalldatetime] NULL,
 CONSTRAINT [PK_tb_smallBig] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_smallType', N'COLUMN',N'id'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'数据库流水号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_smallType', @level2type=N'COLUMN',@level2name=N'id'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_smallType', N'COLUMN',N'bigId'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'大类别表的外键' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_smallType', @level2type=N'COLUMN',@level2name=N'bigId'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_smallType', N'COLUMN',N'smallName'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'小类别的名称' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_smallType', @level2type=N'COLUMN',@level2name=N'smallName'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_smallType', N'COLUMN',N'creaTime'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'创建时间' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_smallType', @level2type=N'COLUMN',@level2name=N'creaTime'
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[tb_orderDetail]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[tb_orderDetail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[orderNumber] [varchar](54) NULL,
	[goodsId] [int] NULL,
	[price] [float] NULL,
	[number] [int] NULL
) ON [PRIMARY]
END
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_orderDetail', N'COLUMN',N'id'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'数据库流水号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_orderDetail', @level2type=N'COLUMN',@level2name=N'id'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_orderDetail', N'COLUMN',N'orderNumber'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'订货编号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_orderDetail', @level2type=N'COLUMN',@level2name=N'orderNumber'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_orderDetail', N'COLUMN',N'goodsId'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'商品编号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_orderDetail', @level2type=N'COLUMN',@level2name=N'goodsId'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_orderDetail', N'COLUMN',N'price'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'商品价格' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_orderDetail', @level2type=N'COLUMN',@level2name=N'price'
GO
IF NOT EXISTS (SELECT * FROM ::fn_listextendedproperty(N'MS_Description' , N'SCHEMA',N'dbo', N'TABLE',N'tb_orderDetail', N'COLUMN',N'number'))
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'商品数量' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'tb_orderDetail', @level2type=N'COLUMN',@level2name=N'number'
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_tb_good_tb_smallType]') AND parent_object_id = OBJECT_ID(N'[dbo].[tb_goods]'))
ALTER TABLE [dbo].[tb_goods]  WITH NOCHECK ADD  CONSTRAINT [FK_tb_good_tb_smallType] FOREIGN KEY([smallId])
REFERENCES [dbo].[tb_smallType] ([id])
GO
ALTER TABLE [dbo].[tb_goods] CHECK CONSTRAINT [FK_tb_good_tb_smallType]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_tb_smallBig_tb_bigType]') AND parent_object_id = OBJECT_ID(N'[dbo].[tb_smallType]'))
ALTER TABLE [dbo].[tb_smallType]  WITH NOCHECK ADD  CONSTRAINT [FK_tb_smallBig_tb_bigType] FOREIGN KEY([bigId])
REFERENCES [dbo].[tb_bigType] ([id])
GO
ALTER TABLE [dbo].[tb_smallType] CHECK CONSTRAINT [FK_tb_smallBig_tb_bigType]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_tb_orderDetail_tb_order]') AND parent_object_id = OBJECT_ID(N'[dbo].[tb_orderDetail]'))
ALTER TABLE [dbo].[tb_orderDetail]  WITH NOCHECK ADD  CONSTRAINT [FK_tb_orderDetail_tb_order] FOREIGN KEY([orderNumber])
REFERENCES [dbo].[tb_order] ([number])
GO
ALTER TABLE [dbo].[tb_orderDetail] CHECK CONSTRAINT [FK_tb_orderDetail_tb_order]
