CREATE TABLE Quyen 
( id int primary key UNIQUE,
 tenquyen varchar(25) NOT NULL,
 quyen int NOT NULL,
 ghichu varchar(255)
);
CREATE TABLE Hesogio
( id int primary key UNIQUE,
 heso float NOT NULL UNIQUE,
 ghichu varchar(255)
);
CREATE TABLE Hesongay
( id int primary key UNIQUE,
 heso float NOT NULL UNIQUE,
 ghichu varchar(255)
);
CREATE TABLE Loaive
( id int primary key UNIQUE,
 loai varchar(25) NOT NULL UNIQUE,
 ghichu varchar(25)
);
CREATE TABLE Diachi
( id int primary key UNIQUE,
 xa varchar(25),
 huyen varchar(25),
 tinh varchar(25) NOT NULL,
 quocgia varchar(25) NOT NULL
);
CREATE TABLE Thongtinnguoidung
( id int primary key UNIQUE,
 Ho varchar(15) NOT NULL,
 Tendem varchar(15) NOT NULL,
 Ten varchar(25) NOT NULL,
 Ngaysinh timestamp,
 Email varchar(25) NOT NULL,
 Sdt char(10) NOT NULL,
 DiachiID int NOT NULL,
 FOREIGN KEY(DiachiID) REFERENCES Diachi(id)
);
CREATE TABLE Nguoidung
( id int primary key UNIQUE,
 taikhoan varchar(25) UNIQUE NOT NULL,
 matkhau varchar(25) NOT NULL,
 thongtinnguoidungID int NOT NULL,
 QuyenID int NOT NULL,
 Tinhtrang boolean,
 FOREIGN KEY(thongtinnguoidungID) REFERENCES Thongtinnguoidung(id),
 FOREIGN KEY(QuyenID) REFERENCES Quyen(id)
);
CREATE TABLE Sanbay
( id int primary key UNIQUE,
 sanbay varchar(30) UNIQUE NOT NULL,
 Tinh varchar(25) NOT NULL,
 Quocgia varchar(25) NOT NULL
 );
CREATE TABLE Tuyenduongbay
( id int primary key UNIQUE,
 diemdi varchar(25) NOT NULL,
 diemden varchar(25) NOT NULL,
 thoigiandichuyen float NOT NULL,
 phothongtietkiem float NOT NULL,
 phothongtieuchuan float NOT NULL,
 thuonggiatieuchuan float NOT NULL,
 thuonggiacaocap float NOT NULL,
 FOREIGN KEY(diemdi) REFERENCES Sanbay(sanbay),
 FOREIGN KEY(diemden) REFERENCES Sanbay(sanbay)
);
CREATE TABLE Lichbay
( id int primary key UNIQUE,
 tuyenduongbayid int NOT NULL,
 thoigiankhoihanh timestamp NOT NULL,
 hesogio float NOT NULL,
 hesongay float NOT NULL,
 khoitao timestamp NOT NULL,
 FOREIGN KEY(hesogio) REFERENCES Hesogio(heso),
 FOREIGN KEY(hesongay) REFERENCES Hesongay(heso),
 FOREIGN KEY(tuyenduongbayid) REFERENCES Tuyenduongbay(id)
);
CREATE TABLE MayBay
( id int primary key UNIQUE,
 hang varchar(25) NOT NULL,
 loai varchar(25) NOT NULL,
 sohieu varchar(25) NOT NULL UNIQUE,
 ghichu varchar(25)
);
CREATE TABLE Ghe
( id int UNIQUE,
 maybayid int NOT NULL,
 hang varchar(25) NOT NULL,
 ghichu varchar(255),
 FOREIGN KEY(maybayid) REFERENCES Maybay(id),
 PRIMARY KEY(maybayid,id)
);
CREATE TABLE Chuyenbay
( id int primary key UNIQUE,
 lichbayid int NOT NULL,
 maybayid int NOT NULL,
 tinhtrang boolean NOT NULL,
 banggiaid int NOT NULL,
 phothongtietkiem float ,
 phothongtieuchuan float ,
 thuonggiatieuchuan float ,
 thuonggiacaocap float ,
 FOREIGN KEY(lichbayid) REFERENCES Lichbay(id),
 FOREIGN KEY(maybayid) REFERENCES Maybay(id)
);
CREATE TABLE Ve
( id int PRIMARY KEY UNIQUE,
 diemdi varchar(25) NOT NULL,
 diemden varchar(25) NOT NULL,
 thoigiankhoihanh timestamp NOT NULL,
 hovaten varchar(75) NOT NULL,
 chuyenbayid int NOT NULL,
 loaive varchar(25) NOT NULL,
 thongtinnguoidungid int NOT NULL,
 FOREIGN KEY(chuyenbayid) REFERENCES Chuyenbay(id),
 FOREIGN KEY(thongtinnguoidungid) REFERENCES Thongtinnguoidung(id),
 FOREIGN KEY(loaive) REFERENCES Loaive(loai)
);
CREATE TABLE Phieudatcho
( id int PRIMARY KEY UNIQUE,
 veid  int NOT NULL,
 mamaybayid int NOT NULL,
 magheid int NOT NULL,
 khoitao timestamp NOT NULL,
 FOREIGN KEY(veid) REFERENCES Ve(id),
 FOREIGN KEY(magheid) REFERENCES Ghe(id)
);
CREATE TABLE Hoadon
( id int PRIMARY KEY UNIQUE,
 phieudatchoid int NOT NULL,
 tonghoadon float NOT NULL,
 FOREIGN KEY(phieudatchoid) REFERENCES Phieudatcho(id)
)
