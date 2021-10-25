CREATE TABLE tblDiaChi
(
    id      SERIAL    NOT NULL,
    Xa      char(255),
    Huyen   char(255),
    Tinh    char(255) NOT NULL,
    Quocgia char(255) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE tblNguoiDung
(
    "id"               SERIAL NOT NULL,
    TenNguoiDung        varchar   NOT NULL,
    MatKhau             varchar   NOT NULL,
    Quyen               int    NOT NULL,
    Tinhtrang           int   NOT NULL,
    ThongtinNguoiDungID int   NOT NULL,
    ngaykhoitao         timestamp   NOT NULL,
    PRIMARY KEY ("id")
);
CREATE TABLE tblThongtinNguoiDung
(
    ID          SERIAL    NOT NULL,
    Ho          char(255) NOT NULL,
    Tendem      char(255) NOT NULL,
    Ngaysinh    DATE      NOT NULL,
    Ten         char(255) NOT NULL,
    Email       char(255) NOT NULL,
    Sodienthoai char(255) NOT NULL,
    tblDiaChiid int      NOT NULL,
    PRIMARY KEY (ID)
);
CREATE TABLE tblQuyen
(
    ID    SERIAL NOT NULL,
    Quyen int   NOT NULL,
    PRIMARY KEY (ID)
);
CREATE TABLE tblMayBay
(
    id         SERIAL    NOT NULL,
    loaimaybay char(255) NOT NULL,
    hang       char(255) NOT NULL,
    sohieu     char(255) NOT NULL,
    ghichu     char(255) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE tblGhe
(
    id          int     NOT NULL,
    loaighe     int    NOT NULL,
    maSoghe     char(4) NOT NULL UNIQUE,
    tblMayBayid int    NOT NULL UNIQUE,
    PRIMARY KEY (maSoghe, tblMayBayid)
);
CREATE TABLE tblLichBay
(
    id                 SERIAL    NOT NULL,
    phothongtietkiem   float    NOT NULL,
    phothongtieuchuan  float    NOT NULL,
    thuonggiatieuchuan float    NOT NULL,
    thuonggiacaocap    float    NOT NULL,
    tblTuyenDuongBayid int      NOT NULL,
    tblHeSoGioid       int      NOT NULL,
    tblHeSoNgayid      int      NOT NULL,
    tblBangGiaid       int      NOT NULL,
    thoigian           timestamp NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE tblTuyenDuongBay
(
    id           SERIAL    NOT NULL,
    tblDiaChiid  int        NOT NULL,
    tblDiaChiid2 int        NOT NULL,
    thoigian     float      NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE tblChuyenBay
(
    id            SERIAL NOT NULL,
    MayBayid      int   NOT NULL,
    LichBayid     int   NOT NULL,
    tblMayBayid   int   NOT NULL,
    tblLichBayid  int   NOT NULL,
    Tinhtrang     int   NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE tblBangGia
(
    id                 SERIAL    NOT NULL,
    phothongtietkiem   float    NOT NULL,
    phothongtieuchuan  float    NOT NULL,
    thuonggiatieuchuan float    NOT NULL,
    thuonggiacaocap    float    NOT NULL,
    thoigian           timestamp NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE tblPhieuDatCho
(
    id                     SERIAL    NOT NULL,
    tblGhemaSoghe          char(4)   NOT NULL,
    tblGhetblMayBayid      int      NOT NULL,
    tblVeid                int      NOT NULL,
    tblThongtinNguoiDungID int      NOT NULL,
    tblHoaDonid            int,
    LoaiVeid               int      NOT NULL,
    tonggiacuave           int      NOT NULL,
    thoigian               timestamp NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE tblLoaiVe
(
    id  SERIAL NOT NULL,
    ten varchar   NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE tblHoaDon
(
    id         SERIAL    NOT NULL,
    hoten      char(255) NOT NULL,
    tonghoadon int      NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE tblVe
(
    id                     SERIAL    NOT NULL,
    diemdi                 char(255) NOT NULL,
    diemden                char(255) NOT NULL,
    hoten                  char(255) NOT NULL,
    sohieumaybay           int      NOT NULL,
    hangve                 int      NOT NULL,
    masoghe                char(4)   NOT NULL,
    tblThongtinNguoiDungID int      NOT NULL,
    ChuyenBayid            int      NOT NULL,
    tblHoaDonid            int      NOT NULL,
    thoigian               timestamp NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE tblHeSoGio
(
    id     SERIAL    NOT NULL,
    gio    timestamp NOT NULL,
    heso   float    NOT NULL,
    ghichu char(255) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE tblHeSoNgay
(
    id     SERIAL    NOT NULL,
    ngay   date      NOT NULL,
    heso   float    NOT NULL,
    ghichu char(255) NOT NULL,
    PRIMARY KEY (id)
);
ALTER TABLE tblNguoiDung
    ADD CONSTRAINT FKtblNguoiDu308713 FOREIGN KEY (QuyenID) REFERENCES tblQuyen (ID);
ALTER TABLE tblPhieuDatCho
    ADD CONSTRAINT FKtblPhieuDa751462 FOREIGN KEY (LoaiVeid) REFERENCES tblLoaiVe (id);
ALTER TABLE tblNguoiDung
    ADD CONSTRAINT FKtblNguoiDu20606 FOREIGN KEY (ThongtinNguoiDungID) REFERENCES tblThongtinNguoiDung (ID);
ALTER TABLE tblVe
    ADD CONSTRAINT FKtblVe520504 FOREIGN KEY (tblThongtinNguoiDungID) REFERENCES tblThongtinNguoiDung (ID);
ALTER TABLE tblVe
    ADD CONSTRAINT FKtblVe848029 FOREIGN KEY (ChuyenBayid) REFERENCES tblChuyenBay (id);
ALTER TABLE tblChuyenBay
    ADD CONSTRAINT FKtblChuyenB601478 FOREIGN KEY (tblMayBayid) REFERENCES tblMayBay (id);
ALTER TABLE tblLichBay
    ADD CONSTRAINT FKtblLichBay908263 FOREIGN KEY (tblTuyenDuongBayid) REFERENCES tblTuyenDuongBay (id);
ALTER TABLE tblLichBay
    ADD CONSTRAINT FKtblLichBay498943 FOREIGN KEY (tblHeSoGioid) REFERENCES tblHeSoGio (id);
ALTER TABLE tblLichBay
    ADD CONSTRAINT FKtblLichBay681500 FOREIGN KEY (tblHeSoNgayid) REFERENCES tblHeSoNgay (id);
ALTER TABLE tblLichBay
    ADD CONSTRAINT FKtblLichBay138508 FOREIGN KEY (tblBangGiaid) REFERENCES tblBangGia (id);
ALTER TABLE tblChuyenBay
    ADD CONSTRAINT FKtblChuyenB538005 FOREIGN KEY (tblLichBayid) REFERENCES tblLichBay (id);
ALTER TABLE tblGhe
    ADD CONSTRAINT FKtblGhe102253 FOREIGN KEY (tblMayBayid) REFERENCES tblMayBay (id);
ALTER TABLE tblPhieuDatCho
    ADD CONSTRAINT FKtblPhieuDa116865 FOREIGN KEY (tblGhemaSoghe, tblGhetblMayBayid) REFERENCES tblGhe (maSoghe, tblMayBayid);
ALTER TABLE tblTuyenDuongBay
    ADD CONSTRAINT FKtblTuyenDu167482 FOREIGN KEY (tblDiaChiid2) REFERENCES tblDiaChi (id);
ALTER TABLE tblTuyenDuongBay
    ADD CONSTRAINT FKtblTuyenDu184706 FOREIGN KEY (tblDiaChiid) REFERENCES tblDiaChi (id);
ALTER TABLE tblThongtinNguoiDung
    ADD CONSTRAINT FKtblThongti78962 FOREIGN KEY (tblDiaChiid) REFERENCES tblDiaChi (id);
ALTER TABLE tblPhieuDatCho
    ADD CONSTRAINT FKtblPhieuDa582470 FOREIGN KEY (tblVeid) REFERENCES tblVe (id);
ALTER TABLE tblVe
    ADD CONSTRAINT FKtblVe705474 FOREIGN KEY (tblHoaDonid) REFERENCES tblHoaDon (id);
ALTER TABLE tblPhieuDatCho
    ADD CONSTRAINT FKtblPhieuDa322852 FOREIGN KEY (tblThongtinNguoiDungID) REFERENCES tblThongtinNguoiDung (ID);
