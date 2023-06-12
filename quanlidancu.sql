-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 27, 2023 at 07:03 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `cackhoanthu`
--

CREATE TABLE `cackhoanthu` (
  `idkhoanthu` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tenkhoanthu` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `sotien` int(11) NOT NULL,
  `hinhthucthu` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `cackhoanthu`
--

INSERT INTO `cackhoanthu` (`idkhoanthu`, `tenkhoanthu`, `sotien`, `hinhthucthu`) VALUES
('dg01', 'Ủng hộ ngày thương binh-liệt sỹ 27/07', 0, 'hokhau'),
('dg02', 'Ủng hộ ngày tết thiếu nhi', 0, 'hokhau'),
('dg03', 'Ủng hộ vì người nghèo', 0, 'hokhau'),
('dg04', 'Trợ giúp đồng bào bị ảnh hưởng bão lụt', 0, 'hokhau'),
('tp01', 'Phí vệ sinh', 6000, 'nhankhau'),
('tp02', 'Phí nước sinh hoạt', 100000, 'nhankhau'),
('tp03', 'Tiền điện ', 200000, 'nhankhau'),
('tp04', 'Phí Internet', 200000, 'hokhau'),
('tp05', 'Phí trông xe', 50000, 'hokhau');

-- --------------------------------------------------------

--
-- Table structure for table `hokhautable`
--

CREATE TABLE `hokhautable` (
  `idhokhau` int(11) NOT NULL,
  `sohokhau` varchar(10) NOT NULL,
  `tenchuho` varchar(50) DEFAULT NULL,
  `makhuvuc` varchar(45) DEFAULT NULL,
  `diachi` varchar(50) DEFAULT NULL,
  `ngaytao` date DEFAULT NULL,
  `ngaychuyendi` date DEFAULT NULL,
  `lydochuyen` varchar(100) DEFAULT NULL,
  `nguoithuchien` varchar(45) DEFAULT NULL,
  `ghichu` varchar(45) DEFAULT NULL,
  `diem` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `hokhautable`
--

INSERT INTO `hokhautable` (`idhokhau`, `sohokhau`, `tenchuho`, `makhuvuc`, `diachi`, `ngaytao`, `ngaychuyendi`, `lydochuyen`, `nguoithuchien`, `ghichu`, `diem`) VALUES
(1, 'HK01', 'Trần Anh Nguyên', 'HN003', '25 phố Nghĩa Đô, quận Cầu Giấy, Hà Nội', '2000-03-12', '2002-03-12', 'Làm ăn', 'Phùng Văn Minh', '', 16),
(2, 'HK02', 'Nguyễn Mạnh Cường', 'HN003', '139 phố Nghĩa Đô, quận Cầu Giấy, Hà Nội', '2003-07-20', '2005-07-20', 'Công tác', 'Nguyễn Cẩm Tú', '', 13),
(3, 'HK03', 'Lê Đình Lâm', 'HN003', '27 đường Lê Văn Lương. quận Thanh Xuân, Hà Nội', '1999-04-03', '2000-03-02', 'Gia Đình', 'Đào Thị Thúy', NULL, 11),
(4, 'HK04', 'Trần Bình Thọ', 'HN002', '123 đường Giải Phóng, quận Thanh Xuân, Hà Nội', '2001-03-11', '2004-12-03', 'Làm Ăn', 'Lê Thị Tuyết', NULL, 2),
(5, 'HK05', 'Vương Đình Trí', 'HN001', '24 đường Trần Khát Chân, Quận Thanh Xuân, Hà Nội', '2002-03-05', '2006-10-03', 'Công Tác', 'Trần Thị Vy', NULL, 1),
(6, 'HK06', 'Phùng Văn Minh', 'HN', 'Số 12 Phố Phương Liệt', '2015-08-07', NULL, NULL, NULL, NULL, 24),
(7, 'HK07', 'Trần Đức Thọ ', 'HN', 'Số 47 Phố Kim Đồng', '2017-07-21', NULL, NULL, NULL, NULL, 19),
(8, 'HK08', 'Trần Đức Thắng', 'HN', 'Số 15 Đội Cấn', '2018-06-12', NULL, NULL, NULL, NULL, 21),
(9, 'HK09', 'Phạm Anh Tú', 'HN', 'Số 46 Trần Đại Nghĩa', '2017-09-23', NULL, NULL, NULL, NULL, 17),
(10, 'HK10', 'Nguyễn Ngọc Sơn', 'HN', 'Số 56 Trương Định', '2016-03-05', NULL, NULL, NULL, NULL, 17);

-- --------------------------------------------------------

--
-- Table structure for table `nhankhautable`
--

CREATE TABLE `nhankhautable` (
  `idnhankhau` int(11) NOT NULL,
  `sohokhau` varchar(10) NOT NULL,
  `madinhdanh` varchar(10) NOT NULL,
  `hoten` varchar(50) DEFAULT NULL,
  `bidanh` varchar(45) DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `noisinh` varchar(45) DEFAULT NULL,
  `diachihientai` varchar(45) DEFAULT NULL,
  `gioitinh` varchar(10) DEFAULT NULL,
  `nguyenquan` varchar(45) DEFAULT NULL,
  `dantoc` varchar(45) DEFAULT NULL,
  `nghenghiep` varchar(50) DEFAULT NULL,
  `noilamviec` varchar(45) DEFAULT NULL,
  `socmnd` varchar(45) DEFAULT NULL,
  `ngaycapcmnd` date DEFAULT NULL,
  `noicapcmnd` varchar(45) DEFAULT NULL,
  `ghichu` varchar(100) DEFAULT NULL,
  `ngaydkthuongtru` date DEFAULT NULL,
  `noithuongtrutruoc` varchar(45) DEFAULT NULL,
  `quanhechuho` varchar(45) DEFAULT NULL,
  `trangthai` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `nhankhautable`
--

INSERT INTO `nhankhautable` (`idnhankhau`, `sohokhau`, `madinhdanh`, `hoten`, `bidanh`, `ngaysinh`, `noisinh`, `diachihientai`, `gioitinh`, `nguyenquan`, `dantoc`, `nghenghiep`, `noilamviec`, `socmnd`, `ngaycapcmnd`, `noicapcmnd`, `ghichu`, `ngaydkthuongtru`, `noithuongtrutruoc`, `quanhechuho`, `trangthai`) VALUES
(1, 'HK01', 'NK0001', 'Trần Anh Nguyên', '', '1985-03-12', 'Hà Nội', 'Hà Nội', 'Nam', 'Hà Nội', 'Kinh', 'Kinh Doanh', 'Hà Nội', '002300001234', '2000-11-12', 'Hà Nội', '', '2000-03-12', '', 'Chủ hộ', 'Thường trú'),
(2, 'HK01', 'NK0002', 'Lê Thị Cúc', '', '1993-09-10', 'Bắc Ninh', 'Hà Nội', 'Nữ', 'Quảng Ninh', 'Kinh', 'Nội Trợ', 'Hà Nội', '001200004821', '2002-12-09', 'Bắc Ninh', '', '2000-09-11', '', 'Vợ', 'Thường trú'),
(5, 'HK01', 'NK0003', 'Trần Thị Hồng', NULL, '2000-05-12', 'Hà Nội', 'Hà Nội', 'Nữ', 'Hà Nội', 'Kinh', 'Sinh Viên', 'Bách khoa', '001400009221', '2015-04-05', 'Hà Nội', '', '2004-03-02', '', 'Con', 'Thường trú'),
(21, 'HK06', 'NK0021', 'Phùng Văn Minh', NULL, '1992-03-16', 'Vĩnh Phúc', 'Số 12 Phố Phương Liệt', 'Nam', 'Vĩnh Phúc', 'Kinh', 'Kỹ Sư', 'Oracle', '211992031621', '2010-05-05', 'CA tỉnh Vĩnh Phúc', NULL, '2015-08-07', 'Số 9 Tạ Quang Bửu', 'Chủ hộ', NULL),
(22, 'HK06', 'NK0022', 'Bùi Thị Thu Trang', NULL, '1994-09-08', 'Vĩnh Phúc', 'Số 12 Phố Phương Liệt', 'Nữ', 'Vĩnh Phúc', 'Kinh', 'Trưởng Phòng', 'Deloitte', '221994090822', '2012-07-06', 'CA tỉnh Vĩnh Phúc', NULL, '2015-08-07', 'Số 9 Tạ Quang Bửu', 'Vợ', NULL),
(23, 'HK06', 'NK0023', 'Phùng Thu Thủy', NULL, '2014-02-14', 'Hà Nội', 'Số 12 Phố Phương Liệt', 'Nữ', 'Vĩnh Phúc', 'Kinh', NULL, NULL, NULL, NULL, NULL, NULL, '2015-08-07', 'Số 9 Tạ Quang Bửu', 'Con', NULL),
(24, 'HK06', 'NK0024', 'Phùng Tuấn Kiệt', NULL, '2015-03-12', 'Hà Nội', 'Số 12 Phố Phương Liệt', 'Nam', 'Vĩnh Phúc', 'Kinh', NULL, NULL, NULL, NULL, NULL, NULL, '2015-08-07', 'Số 9 Tạ Quang Bửu', 'Con', NULL),
(25, 'HK07', 'NK0025', 'Trần Đức Thọ', NULL, '1993-06-05', 'Thái Bình', 'Số 47 Phố Kim Đồng', 'Nam', 'Thái Bình', 'Kinh', 'Kiểm Toán', 'BigC', '251993060525', '2011-03-04', 'CA tỉnh Thái Bình', NULL, '2017-07-21', 'Số 15 Nguyễn Hiền', 'Chủ hộ', NULL),
(26, 'HK07', 'NK0026', 'Phạm Thu Hương', NULL, '1995-04-04', 'Yên Bái', 'Số 47 Phố Kim Đồng', 'Nữ', 'Yên Bái', 'Kinh', 'Nhân Viên', 'FPT', '261995040426', '2013-05-12', 'CA tỉnh Yên Bái', NULL, '2017-07-21', 'Số 15 Nguyễn Hiền', 'Vợ', NULL),
(27, 'HK07', 'NK0027', 'Trần Đức Thiện', NULL, '2015-04-23', 'Hà Nội', 'Số 47 Phố Kim Đồng', 'Nam', 'Thái Bình', 'Kinh', NULL, NULL, NULL, NULL, NULL, NULL, '2017-07-21', 'Số 15 Nguyễn Hiền', 'Con', NULL),
(28, 'HK07', 'NK0028', 'Trần Thùy Linh', NULL, '2017-01-26', 'Hà Nội', 'Số 47 Phố Kim Đồng', 'Nữ', 'Thái Bình', 'Kinh', NULL, NULL, NULL, NULL, NULL, NULL, '2017-07-21', 'Số 15 Nguyễn Hiền', 'Con', NULL),
(29, 'HK08', 'NK0029', 'Trần Đức Thắng', NULL, '1990-10-11', 'Yên Bái', 'Số 15 Đội Cấn', 'Nam', 'Yên Bái', 'Kinh', 'Phi Công', 'VietNamAirlines', '291990101129', '2008-07-24', 'CA tỉnh Yên Bái', NULL, '2018-06-12', 'Số 206 Bạch Mai', 'Chủ hộ', NULL),
(30, 'HK08', 'NK0030', 'Nguyễn Thu Hà', NULL, '1993-02-15', 'Sơn La', 'Số 15 Đội Cấn', 'Nữ', 'Sơn La', 'Kinh', 'Giáo Viên', 'THPT Tạ Quang Bửu', '301993021530', '2011-09-14', 'CA tỉnh Sơn La', NULL, '2018-06-12', 'Số 206 Bạch Mai', 'Vợ ', NULL),
(31, 'HK08', 'NK0031', 'Trần Thanh Thúy', NULL, '2014-03-02', 'Hà Nội', 'Số 15 Đội Cấn', 'Nữ', 'Yên Bái', 'Kinh', NULL, NULL, NULL, NULL, NULL, NULL, '2018-06-12', 'Số 206 Bạch Mai', 'Con', NULL),
(32, 'HK08', 'NK0032', 'Trần Thu Trang', NULL, '2016-05-12', 'Hà Nội', 'Số 15 Đội Cấn', 'Nữ', 'Yên Bái', 'Kinh', NULL, NULL, NULL, NULL, NULL, NULL, '2018-06-12', 'Số 206 Bạch Mai', 'Con', NULL),
(33, 'HK09', 'NK0033', 'Phạm Anh Tú', NULL, '1989-09-17', 'Phú Thọ', 'Số 46 Trần Đại Nghĩa', 'Nam', 'Phú Thọ', 'Kinh', 'Giảng Viên', 'ĐH BKHN', '331989091733', '2007-05-02', 'CA tỉnh Phú Thọ', NULL, '2017-09-23', 'Số 103 Đại Cồ Việt', 'Chủ hộ', NULL),
(34, 'HK09', 'NK0034', 'Bùi Mai Anh', NULL, '1991-08-23', 'Vĩnh Phúc', 'Số 46 Trần Đại Nghĩa', 'Nữ', 'Vĩnh Phúc', 'Kinh', 'Giảng Viên', 'ĐH KTQD', '341991082334', '2009-11-12', 'CA tỉnh Vĩnh Phúc', NULL, '2017-09-23', 'Số 103 Đại Cồ Việt', 'Vợ', NULL),
(35, 'HK09', 'NK0035', 'Phạm Tuấn Sơn', NULL, '2013-02-03', 'Hà Nội', 'Số 46 Trần Đại Nghĩa', 'Nam', 'Phú Thọ', 'Kinh', NULL, NULL, NULL, NULL, NULL, NULL, '2017-09-23', 'Số 103 Đại Cồ Việt', 'Con', NULL),
(36, 'HK09', 'NK0036', 'Phạm Lê Na', NULL, '2015-05-02', 'Hà Nội', 'Số 46 Trần Đại Nghĩa', 'Nam', 'Phú Thọ', 'Kinh', NULL, NULL, NULL, NULL, NULL, NULL, '2017-09-23', 'Số 103 Đại Cồ Việt', 'Con', NULL),
(37, 'HK10', 'NK0037', 'Nguyễn Ngọc Sơn', NULL, '1993-09-08', 'Nam Định', 'Số 56 Trương Định', 'Nam', 'Nam Định ', 'Kinh', 'Cán Bộ', 'Bộ Giáo Dục', '371993090837', '2011-10-16', 'CA tỉnh Nam Định', NULL, '2016-03-05', 'Số 34 Lĩnh Nam', 'Chủ hộ', NULL),
(38, 'HK10', 'NK0038', 'Trần Thu Dương', NULL, '1993-02-16', 'Nghệ An', 'Số 56 Trương Định', 'Nữ', 'Nghệ An', 'Kinh', 'Kế Toán', 'VinGroup', '381993021638', '2011-04-18', 'CA tỉnh Nghệ An', NULL, '2016-03-05', 'Số 34 Lĩnh Nam', 'Vợ', NULL),
(39, 'HK10', 'NK0039', 'Nguyễn Ngọc Dung', NULL, '2013-04-25', 'Hà Nội', 'Số 56 Trương Định', 'Nữ', 'Nam Định ', 'Kinh', NULL, NULL, NULL, NULL, NULL, NULL, '2016-03-05', 'Số 34 Lĩnh Nam', 'Con', NULL),
(40, 'HK10', 'NK0040', 'Nguyễn Ngọc Giang', NULL, '2015-05-23', 'Hà Nội', 'Số 56 Trương Định', 'Nữ', 'Nam Định', 'Kinh', NULL, NULL, NULL, NULL, NULL, NULL, '2016-03-05', 'Số 34 Lĩnh Nam', 'Con', NULL),
(54, 'HK01', 'NK0004', 'Trần Quang Anh', NULL, '2002-11-09', 'Hà Nội', 'Hà Nội', 'Nam', 'Hà Nội', 'Kinh', 'Học Sinh', 'Cầu giấy', '001500009284', '2017-06-08', 'Hà Nội', NULL, '2006-02-12', NULL, 'Con', 'Thường trú'),
(55, 'HK02', 'NK0005', 'Nguyễn Mạnh Cường', NULL, '1982-09-09', 'Quảng Nam', 'Hà Nội', 'Nam', 'Quảng Nam', 'Kinh', 'Coder', 'Hà Nội', '003400001235', '1993-03-09', 'Quảng Nam', NULL, '2003-02-03', NULL, 'Chủ hộ', 'Thường trú'),
(56, 'HK02', 'NK0006', 'Phạm Thị Mĩ Hạnh', NULL, '1990-03-04', 'Thanh Hóa', 'Hà Nội', 'Nữ', 'Thanh Hóa', 'Kinh', 'Kế toán', 'SHB Giang Văn Minh', '001200003948', '2000-12-11', 'Thanh Hóa', NULL, '2005-03-02', NULL, 'Vợ', 'Thường trú'),
(57, 'HK02', 'NK0007', 'Phạm Thị Kiều Linh', NULL, '1995-04-12', 'Hà Nội', 'Hà Nội', 'Nữ', 'Hà Nội', 'Kinh', 'Phụ Tá', 'Techcombank', '001400009283', '2003-12-05', 'Hà Nội', NULL, '2007-12-11', NULL, 'Con', 'Thường trú'),
(58, 'HK02', 'NK0008', 'Nguyễn Quang Vinh', NULL, '2000-05-01', 'Hà Nội', 'Hà Nội', 'Nam', 'Hà Nội', 'Kinh', 'Sinh Viên', 'Ngoại Thương', '001300001923', '2010-03-06', 'Hà Nội', NULL, '2005-09-09', NULL, 'Con', 'Thường trú'),
(59, 'HK03', 'NK0009', 'Lê Đình Lâm', NULL, '1996-03-01', 'Quảng Trị', 'Hà Nội', 'Nam', 'Quảng Trị', 'Kinh', 'Sửa xe máy', 'Cầy Giấy', '001400009283', '2009-12-03', 'Hà Nội', NULL, '2014-12-12', NULL, 'Chủ hộ', 'Thường trú'),
(60, 'HK03', 'NK0010', 'Lê Thị Yến', NULL, '2000-03-05', 'Hà Nội', 'Hà Nội', 'Nữ', 'Hà Nội', 'Kinh', 'Kế toán', 'Viettel', '009800020345', '2012-03-08', 'Hà Nội', NULL, '2018-04-02', NULL, 'Vợ', 'Thường trú'),
(61, 'HK03', 'NK0011', 'Lê Đình Hải', NULL, '2003-09-01', 'Hà Nội', 'Hà Nội', 'Nam', 'Hà Nội', 'Kinh', 'Học sinh', 'Nghĩa Đô', '008322220993', '2018-03-01', 'Hà Nội', NULL, '2020-01-01', NULL, 'Con', 'Thường trú'),
(62, 'HK03', 'NK0012', 'Lê Thị Huệ', NULL, '2005-02-04', 'Hà Nội', 'Hà Nội', 'Nữ', 'Hà Nội', 'Kinh', 'Học Sinh', 'Nghĩa Đô', '003400001912', '2018-12-12', 'Hà Nội', NULL, '2020-01-03', NULL, 'Con', 'Thường trú'),
(63, 'HK04', 'NK0013', 'Trần Bình Thọ', NULL, '1970-03-02', 'Hà Nội', 'Hà Nội', 'Nam', 'Hà Nội', 'Kinh', 'Về Hưu', 'Bạch Mai', '009783110022', '1990-10-11', 'Hà Nội', NULL, '2000-10-12', NULL, 'Chủ hộ', 'Thường trú'),
(64, 'HK04', 'NK0014', 'Nguyễn Thị Thúy', NULL, '1980-12-10', 'Bình Định', 'Hà Nội', 'Nữ', 'Bình Định', 'Kinh', 'Bán Hàng', 'Cầu Giấy', '003400001929', '1995-12-03', 'Hà Nội', NULL, '2003-12-04', NULL, 'Vợ', 'Thường trú'),
(65, 'HK04', 'NK0015', 'Trần Đinh Hà', NULL, '1985-10-02', 'Hà Nội', 'Hà Nội', 'Nam', 'Hà Nội', 'Kinh', 'CEO', 'Ngân hàng nhà nước', '0019000019234', '1999-10-10', 'Hà Nội', NULL, '2005-12-09', NULL, 'Con', 'Thường trú'),
(66, 'HK04', 'NK0016', 'Trần Bình Hà', NULL, '1988-12-12', 'Hà Nội', 'Hà Nội', 'Nam', 'Hà Nội', 'Kinh', 'Chủ tịch', 'Viettinbank', '001930009898', '1993-12-03', 'Hà Nội', NULL, '2007-01-02', NULL, 'Con', 'Thường trú'),
(67, 'HK05', 'NK0017', 'Vương Đình Trí', NULL, '1990-11-03', 'Quảng Bình', 'Hà Nội', 'Nam', 'Quảng Bình', 'Kinh', 'Bán buôn', 'Chợ Nghĩa Đô', '001200003948', '1999-02-03', 'Hà Nội', NULL, '2005-03-07', NULL, 'Chủ hộ', 'Thường trú'),
(68, 'HK05', 'NK0018', 'Lê Thanh Ngân ', NULL, '1995-10-02', 'Hà Nội', 'Hà Nội', 'Nữ', 'Hà Nội', 'Kinh', 'Nhân Viên', 'Vincom', '001300001983', '2000-01-05', 'Hà Nội', NULL, '2008-12-10', NULL, 'Vợ', 'Thường trú'),
(69, 'HK05', 'NK0019', 'Lê Đình Nam', NULL, '2000-12-01', 'Hà Nội', 'Hà Nội', 'Nam', 'Hà Nội', 'Kinh', 'Sinh Viên', 'KTQD', '001930002841', '2009-10-03', 'Hà Nội', NULL, '2014-12-04', NULL, 'Con', 'Thường trú'),
(70, 'HK05', 'NK0020', 'Vương Quân Long', NULL, '2001-11-03', 'Hà Nội', 'Hà Nội', 'Nam', 'Hà Nội', 'Kinh', 'Sinh Viên', 'Xây dựng', '0109290000', '2010-02-10', 'Hà Nội', NULL, '2016-10-09', NULL, 'Con', 'Thường trú');

-- --------------------------------------------------------

--
-- Table structure for table `taikhoantable`
--

CREATE TABLE `taikhoantable` (
  `id` varchar(10) NOT NULL,
  `taikhoan` varchar(50) DEFAULT NULL,
  `matkhau` varchar(10) DEFAULT NULL,
  `chucvu` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `taikhoantable`
--

INSERT INTO `taikhoantable` (`id`, `taikhoan`, `matkhau`, `chucvu`) VALUES
('1', 'totruong', '1', 'totruong'),
('2', 'topho', '1', 'topho'),
('3', 'ketoan', '1', 'ketoan'),
('4', 'admin', '1', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `tamtrutable`
--

CREATE TABLE `tamtrutable` (
  `idtamtru` int(11) NOT NULL,
  `magiaytamtru` varchar(10) DEFAULT NULL,
  `madinhdanh` varchar(10) DEFAULT NULL,
  `sodienthoai` varchar(20) DEFAULT NULL,
  `tungay` date DEFAULT NULL,
  `denngay` date DEFAULT NULL,
  `lydo` varchar(100) DEFAULT NULL,
  `tinhtrang` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tamtrutable`
--

INSERT INTO `tamtrutable` (`idtamtru`, `magiaytamtru`, `madinhdanh`, `sodienthoai`, `tungay`, `denngay`, `lydo`, `tinhtrang`) VALUES
(12, 'TT01', 'NK0002', '', '2022-10-20', '2022-11-20', 'Gia đình', 'Đang tạm trú');

-- --------------------------------------------------------

--
-- Table structure for table `tamvangtable`
--

CREATE TABLE `tamvangtable` (
  `idtamvang` int(11) NOT NULL,
  `magiaytamvang` varchar(10) NOT NULL,
  `madinhdanh` varchar(10) NOT NULL,
  `sohokhau` varchar(10) NOT NULL,
  `noitamtru` varchar(20) DEFAULT NULL,
  `tungay` date DEFAULT NULL,
  `denngay` date DEFAULT NULL,
  `lydo` varchar(100) DEFAULT NULL,
  `tinhtrang` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tamvangtable`
--

INSERT INTO `tamvangtable` (`idtamvang`, `magiaytamvang`, `madinhdanh`, `sohokhau`, `noitamtru`, `tungay`, `denngay`, `lydo`, `tinhtrang`) VALUES
(23, 'TV01', 'NK0009', 'HK03', 'Phú Thọ', '2018-11-30', '2019-01-01', 'Gia đình', 'Hoàn thành tạm vắng');

-- --------------------------------------------------------

--
-- Table structure for table `thuphidonggop`
--

CREATE TABLE `thuphidonggop` (
  `sohokhau` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `idkhoanthu` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `soluong` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `thuphidonggop`
--

INSERT INTO `thuphidonggop` (`sohokhau`, `idkhoanthu`, `soluong`, `id`) VALUES
('HK01', 'tp01', 0, 1),
('HK02', 'tp01', 0, 2),
('HK03', 'tp01', 0, 3),
('HK04', 'tp01', 0, 4),
('HK05', 'tp01', 0, 5),
('HK06', 'tp01', 0, 6),
('HK07', 'tp01', 0, 7),
('HK08', 'tp01', 0, 8),
('HK09', 'tp01', 0, 9),
('HK10', 'tp01', 0, 10),
('HK01', 'tp02', 0, 11),
('HK02', 'tp03', 0, 12),
('HK03', 'tp04', 0, 13),
('HK04', 'tp05', 0, 14),
('HK05', 'dg01', 100000, 15),
('HK06', 'dg02', 200000, 16),
('HK07', 'dg03', 200000, 17),
('HK08', 'dg04', 100000, 18),
('HK09', 'tp02', 0, 19),
('HK10', 'tp03', 200000, 20),
('HK01', 'dg01', 100000, 21),
('HK07', 'tp04', 0, 24),
('HK06', 'dg01', 100000, 25);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cackhoanthu`
--
ALTER TABLE `cackhoanthu`
  ADD PRIMARY KEY (`idkhoanthu`);

--
-- Indexes for table `hokhautable`
--
ALTER TABLE `hokhautable`
  ADD PRIMARY KEY (`idhokhau`),
  ADD UNIQUE KEY `sohokhau_UNIQUE` (`sohokhau`);

--
-- Indexes for table `nhankhautable`
--
ALTER TABLE `nhankhautable`
  ADD PRIMARY KEY (`idnhankhau`),
  ADD UNIQUE KEY `sohokhau_nhankhau` (`sohokhau`,`madinhdanh`),
  ADD KEY `madinhdanh` (`madinhdanh`);

--
-- Indexes for table `taikhoantable`
--
ALTER TABLE `taikhoantable`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tamtrutable`
--
ALTER TABLE `tamtrutable`
  ADD PRIMARY KEY (`idtamtru`),
  ADD UNIQUE KEY `magiaytamtru_UNIQUE` (`magiaytamtru`),
  ADD UNIQUE KEY `madinhdanh_UNIQUE` (`madinhdanh`);

--
-- Indexes for table `tamvangtable`
--
ALTER TABLE `tamvangtable`
  ADD PRIMARY KEY (`idtamvang`);

--
-- Indexes for table `thuphidonggop`
--
ALTER TABLE `thuphidonggop`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hokhautable`
--
ALTER TABLE `hokhautable`
  MODIFY `idhokhau` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `nhankhautable`
--
ALTER TABLE `nhankhautable`
  MODIFY `idnhankhau` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;

--
-- AUTO_INCREMENT for table `tamtrutable`
--
ALTER TABLE `tamtrutable`
  MODIFY `idtamtru` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `tamvangtable`
--
ALTER TABLE `tamvangtable`
  MODIFY `idtamvang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `thuphidonggop`
--
ALTER TABLE `thuphidonggop`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
