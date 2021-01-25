/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.DAOHocVien;
import Models.HocVien;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NgocPJa
 */
public class QuanLyHocVienImplement implements QuanLyHocVien {

    private DAOHocVien _daoHocVien = new DAOHocVien();
    private List<HocVien> _lstHocVien = null;

    public QuanLyHocVienImplement() {
        _lstHocVien = new ArrayList<>();
        _lstHocVien = _daoHocVien.selectAll();
    }

    @Override
    public List<HocVien> getListHocVien() {
        return _lstHocVien;
    }

    @Override
    public boolean addHocVien(HocVien hocVien) {
        if (hocVien != null) {
            for (HocVien x : _lstHocVien) {
                if (hocVien.getMaNguoiHoc().equals(x.getMaNguoiHoc())
                        && hocVien.getMaKhoaHoc().equals(x.getMaKhoaHoc())) {
                    return false;
                }
            }
            if (_daoHocVien.insert(hocVien)) {
                hocVien.setMaHocVien(_daoHocVien.getIdentity() + "");
                _lstHocVien.add(hocVien);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeHocVien(String maHocVien) {
        if (maHocVien != null) {
            int index = getIndexHocVien(maHocVien);
            if (index > -1) {
                if (_daoHocVien.delete(maHocVien)) {
                    _lstHocVien.remove(index);
                    return true;
                }
            }
        }
        return false;
    }

    private int getIndexHocVien(String maHocVien) {
        if (maHocVien == null) {
            return -2;
        }
        for (int i = 0; i < _lstHocVien.size(); i++) {
            if (maHocVien.equals(_lstHocVien.get(i).getMaHocVien())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public HocVien getHocVienById(String maHocVien) {
        if (maHocVien != null) {
            for (HocVien x : _lstHocVien) {
                if (x.getMaHocVien().equals(maHocVien)) {
                    return x;
                }
            }
        }
        return null;
    }

    @Override
    public boolean editHocVien(HocVien hocVien) {
        if (hocVien != null) {
            for (HocVien x : _lstHocVien) {
                if (x.getMaHocVien().equals(hocVien.getMaHocVien())) {
                    if (_daoHocVien.update(hocVien)) {
                        x.setDiem(hocVien.getDiem());
                        return true;
                    }
                }
            }
        }
        return true;
    }

}
