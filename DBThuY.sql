CREATE DATABASE SucKhoeThuY;
use SucKhoeThuY;
CREATE TABLE danhmucdongvat(
    id int IDENTITY(1,1) PRIMARY KEY not null,
    madm varchar(50) not null,
    tendm NVARCHAR(50) not null,
    trangthai int not null
)
CREATE Table danhsachdongvat(
    id int IDENTITY(1,1) PRIMARY KEY not null,
    madv varchar(50) not null,
    id_danhmuc int not null,
    tendv nvarchar(50) not null,
    cannang float not null,
    ghichu nvarchar(255) not null,
    trangthai int not null
    FOREIGN KEY (id_danhmuc)
    REFERENCES danhmucdongvat(id)
)
CREATE TABLE lichsutiemphong(
    id int IDENTITY(1,1) PRIMARY KEY not null,
    mals varchar(50) not null,
    id_dongvat int not null,
    loaibenh NVARCHAR(50) not null,
    ngaytiem datetime not null,
    trangthai int not null
    FOREIGN KEY (id_dongvat)
    REFERENCES danhsachdongvat(id)
)
CREATE TABLE quanlysuckhoe(
    id int IDENTITY(1,1) PRIMARY KEY not null ,
    maql varchar(50) not null,
    id_dongvat int not null,
    tinhtrangsuckhoe NVARCHAR(255) not null,
    thuocdasudung NVARCHAR(255) not null,
    ghichu NVARCHAR(255) not null,
    ngaytao datetime not null,
    trangthai int not null
    FOREIGN KEY (id_dongvat)
    REFERENCES danhsachdongvat(id)
)
-- Thêm dữ liệu vào bảng danhmucdongvat
INSERT INTO danhmucdongvat (madm, tendm, trangthai) VALUES 
('DM001', N'Động vật có vú', 1),
('DM002', N'Động vật lưỡng cư', 1),
('DM003', N'Động vật bò sát', 1),
('DM004', N'Động vật chim', 1),
('DM005', N'Động vật cá', 1);

-- Thêm dữ liệu vào bảng danhsachdongvat
INSERT INTO danhsachdongvat (madv, id_danhmuc, tendv, cannang, ghichu, trangthai) VALUES 
('DV001', 1, N'Hươu', 150, N'Hươu rừng', 1),
('DV002', 1, N'Hổ', 200, N'Hổ Siberia', 1),
('DV003', 2, N'Ếch', 0.1, N'Ếch nhảy', 1),
('DV004', 2, N'Lưỡi trai', 0.05, N'Lưỡi trai cầu vồng', 1),
('DV005', 3, N'Kỳ nhông', 0.3, N'Kỳ nhông xanh', 1);

-- Thêm dữ liệu vào bảng lichsutiemphong
INSERT INTO lichsutiemphong (mals, id_dongvat, loaibenh, ngaytiem, trangthai) VALUES 
('LS001', 1, N'Bệnh dại', '2024-03-15', 1),
('LS002', 2, N'Bệnh sốt xuất huyết', '2024-03-20', 1),
('LS003', 3, N'Bệnh sán lá gan', '2024-03-25', 1),
('LS004', 4, N'Bệnh cúm', '2024-03-30', 1),
('LS005', 5, N'Bệnh viêm ruột', '2024-04-01', 1);

-- Thêm dữ liệu vào bảng quanlysuckhoe
INSERT INTO quanlysuckhoe (maql, id_dongvat, tinhtrangsuckhoe, thuocdasudung, ghichu, ngaytao, trangthai) VALUES 
('QL001', 1, N'Bình thường', N'Vitamin A', N'Điều trị thường xuyên', '2024-03-15', 1),
('QL002', 2, N'Cần theo dõi', N'Paracetamol', N'Điều trị kịp thời', '2024-03-20', 1),
('QL003', 3, N'Khỏe mạnh', N'Không có', N'Không cần điều trị', '2024-03-25', 1),
('QL004', 4, N'Bị ốm', N'Thạch anh hồng', N'Điều trị cần thiết', '2024-03-30', 1),
('QL005', 5, N'Bình thường', N'Vitamin C', N'Điều trị đúng phương pháp', '2024-04-01', 1);
