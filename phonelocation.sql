-- phpMyAdmin SQL Dump
-- version 3.5.4
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2014 年 10 月 23 日 10:34
-- 服务器版本: 5.1.50-community-log
-- PHP 版本: 5.2.14

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `phonelocation`
--

-- --------------------------------------------------------

--
-- 表的结构 `authorities`
--

CREATE TABLE IF NOT EXISTS `authorities` (
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `authority` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  KEY `FK_q0u5f2cdlshec8tlh6818bhbk` (`authority`),
  KEY `FK_baahryprcge2u172egph1qwur` (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `authorities`
--

INSERT INTO `authorities` (`username`, `authority`) VALUES
('admin', 'ROLE_USER');

-- --------------------------------------------------------

--
-- 表的结构 `iphone`
--

CREATE TABLE IF NOT EXISTS `iphone` (
  `phoneid` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `date` bigint(20) NOT NULL,
  `radius` double NOT NULL,
  `x` double NOT NULL,
  `y` double NOT NULL,
  PRIMARY KEY (`phoneid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `iphone`
--

-- --------------------------------------------------------

--
-- 表的结构 `roles`
--

CREATE TABLE IF NOT EXISTS `roles` (
  `roledesc` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rolename` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  UNIQUE KEY `UK_jdhyvh8di85ai37phukfemdnx` (`rolename`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `roles`
--

INSERT INTO `roles` (`roledesc`, `rolename`) VALUES
('普通角色', 'ROLE_USER'),
('管理员角色', 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- 表的结构 `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` int(11) NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `users`
--

INSERT INTO `users` (`username`, `enabled`, `password`) VALUES
('admin', 1, 'admin');

-- --------------------------------------------------------

--
-- 表的结构 `usersphone`
--

CREATE TABLE IF NOT EXISTS `usersphone` (
  `phonename` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  KEY `FK_kfac7jd1c3lt6e2u17s98gr4w` (`phonename`),
  KEY `FK_lip71asxim7e8dq9s0wkc9993` (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `usersphone`
--


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
