CREATE TABLE tblDiaChi
(
    id      SERIAL    NOT NULL,
    Xa      char(255),
    huyen   char(255),
    tinh    char(255) NOT NULL,
    quocgia char(255) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE tblNguoiDung
(
    "-id"               SERIAL NOT NULL,
    TenNguoiDung        int4   NOT NULL,
    matkhau             int4   NOT NULL,
    ngaykhoitao         date   NOT NULL,
    QuyenID             int4   NOT NULL,
    Tinhtrangid         int4   NOT NULL,
    ThongtinNguoiDungID int4   NOT NULL,
    PRIMARY KEY ("-id")
);
CREATE TABLE tblThongtinNguoiDung
(
    ID          SERIAL    NOT NULL,
    ho          char(255) NOT NULL,
    tendem      char(255) NOT NULL,
    ngaysinh    int4      NOT NULL,
    ten         char(255) NOT NULL,
    email       char(255) NOT NULL,
    sodienthoai char(255) NOT NULL,
    tblDiaChiid int4      NOT NULL,
    PRIMARY KEY (ID)
);
CREATE TABLE tblQuyen
(
    ID    SERIAL NOT NULL,
    Quyen int4   NOT NULL,
    PRIMARY KEY (ID)
);
CREATE TABLE tblTinhtrang
(
    id        SERIAL NOT NULL,
    TInhtrang bytea  NOT NULL,
    PRIMARY KEY (id)
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
    loaighe     int4    NOT NULL,
    maSoghe     char(4) NOT NULL UNIQUE,
    tblMayBayid int4    NOT NULL UNIQUE,
    PRIMARY KEY (maSoghe, tblMayBayid)
);
CREATE TABLE tblLichBay
(
    id                 SERIAL    NOT NULL,
    thoigian           timestamp NOT NULL,
    phothongtietkiem   float4    NOT NULL,
    phothongtieuchuan  float4    NOT NULL,
    thuonggiatieuchuan float4    NOT NULL,
    thuonggiacaocap    float4    NOT NULL,
    tblTuyenDuongBayid int4      NOT NULL,
    tblHeSoGioid       int4      NOT NULL,
    tblHeSoNgayid      int4      NOT NULL,
    tblBangGiaid       int4      NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE tblTuyenDuongBay
(
    id           SERIAL    NOT NULL,
    tblDiaChiid  int4      NOT NULL,
    tblDiaChiid2 int4      NOT NULL,
    thoigian     timestamp NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE tblChuyenBay
(
    id            SERIAL NOT NULL,
    MayBayid      int4   NOT NULL,
    LichBayid     int4   NOT NULL,
    PhieuDatChoid int4   NOT NULL,
    tblMayBayid   int4   NOT NULL,
    tblLichBayid  int4   NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE tblBangGia
(
    id                 SERIAL    NOT NULL,
    phothongtietkiem   float4    NOT NULL,
    phothongtieuchuan  float4    NOT NULL,
    thuonggiatieuchuan float4    NOT NULL,
    thuonggiacaocap    float4    NOT NULL,
    thoigian           timestamp NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE tblPhieuDatCho
(
    id                     SERIAL    NOT NULL,
    thoigian               timestamp NOT NULL,
    tonggiacuave           int4      NOT NULL,
    LoaiVeid               int4      NOT NULL,
    tblGhemaSoghe          char(4)   NOT NULL,
    tblGhetblMayBayid      int4      NOT NULL,
    tblVeid                int4      NOT NULL,
    tblThongtinNguoiDungID int4      NOT NULL,
    tblHoaDonid            int4,
    PRIMARY KEY (id)
);
CREATE TABLE tblLoaiVe
(
    id  SERIAL NOT NULL,
    ten int4   NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE tblHoaDon
(
    id         SERIAL    NOT NULL,
    hoten      char(255) NOT NULL,
    tonghoadon int4      NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE tblVe
(
    id                     SERIAL    NOT NULL,
    diemdi                 char(255) NOT NULL,
    diemden                char(255) NOT NULL,
    hoten                  int4      NOT NULL,
    thoigian               timestamp NOT NULL,
    sohieumaybay           int4      NOT NULL,
    hangve                 int4      NOT NULL,
    masoghe                char(4)   NOT NULL,
    tblThongtinNguoiDungID int4      NOT NULL,
    ChuyenBayid            int4      NOT NULL,
    tblHoaDonid            int4      NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE tblHeSoGio
(
    id     SERIAL    NOT NULL,
    ghichu char(255) NOT NULL,
    gio    timestamp NOT NULL,
    heso   float4    NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE tblHeSoNgay
(
    id     SERIAL    NOT NULL,
    ghichu char(255) NOT NULL,
    ngay   date      NOT NULL,
    heso   float4    NOT NULL,
    PRIMARY KEY (id)
);
ALTER TABLE tblNguoiDung
    ADD CONSTRAINT FKtblNguoiDu308713 FOREIGN KEY (QuyenID) REFERENCES tblQuyen (ID);
ALTER TABLE tblNguoiDung
    ADD CONSTRAINT FKtblNguoiDu329675 FOREIGN KEY (Tinhtrangid) REFERENCES tblTinhtrang (id);
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
