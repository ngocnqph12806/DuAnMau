/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.DAONhanVien;
import Models.NhanVien;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NgocPJa
 */
public class QuanLyNhanVienImplement implements QuanLyNhanVien {

    private DAONhanVien _daoNhanVien = new DAONhanVien();
    private List<NhanVien> _lstNhanVien = null;

    public QuanLyNhanVienImplement() {
        _lstNhanVien = new ArrayList<>();
        _lstNhanVien = _daoNhanVien.selectAll();
    }

    @Override
    public boolean doiMatKhau(NhanVien nhanVien) {
        if (nhanVien != null) {
            if (_daoNhanVien.update(nhanVien)) {
                _lstNhanVien.set(getIndex(nhanVien.getMaNV()), nhanVien);
                return true;
            }
        }
        return false;
    }

    private int getIndex(String maNV) {
        if (maNV == null) {
            return -2;
        }
        if (!maNV.isBlank() || !maNV.isEmpty()) {
            for (int i = 0; i < _lstNhanVien.size(); i++) {
                if (_lstNhanVien.get(i).getMaNV().equalsIgnoreCase(maNV)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public List<NhanVien> getListNhanVien() {
        return _lstNhanVien;
    }

    @Override
    public NhanVien getNhanVienById(String maNhanVien) {
        if (maNhanVien != null) {
            for (NhanVien x : _lstNhanVien) {
                if (x.getMaNV().equalsIgnoreCase(maNhanVien)) {
                    return x;
                }
            }
        }
        return null;
    }

    @Override
    public boolean removeNhanVien(NhanVien nhanVien) {
        if (nhanVien != null) {
            if (getNhanVienById(nhanVien.getMaNV()) != null) {
                if (_daoNhanVien.delete(nhanVien.getMaNV())) {
                    _lstNhanVien.remove(nhanVien);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean addNhanVien(NhanVien nhanVien) {
        if (nhanVien != null) {
            if (getNhanVienById(nhanVien.getMaNV()) == null) {
                if (_daoNhanVien.insert(nhanVien)) {
                    _lstNhanVien.add(nhanVien);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean editNhanVien(NhanVien nhanVien) {
        if (nhanVien != null) {
            int index = getIndex(nhanVien.getMaNV());
            if (index > -1) {
                if (_daoNhanVien.update(nhanVien)) {
                    _lstNhanVien.set(index, nhanVien);
                    return true;
                }
            }
        }
        return false;
    }

}
