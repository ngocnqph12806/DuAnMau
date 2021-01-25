/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.DAOKhoaHoc;
import Models.KhoaHoc;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NgocPJa
 */
public class QuanLyKhoaHocImplement implements QuanLyKhoaHoc {
    
    private DAOKhoaHoc _daoKhoaHoc = new DAOKhoaHoc();
    private List<KhoaHoc> _lstKhoaHocs = null;
    
    public QuanLyKhoaHocImplement() {
        _lstKhoaHocs = new ArrayList<>();
        _lstKhoaHocs = _daoKhoaHoc.selectAll();
    }
    
    @Override
    public List<KhoaHoc> getListKhoaHoc() {
        return _lstKhoaHocs;
    }
    
    @Override
    public KhoaHoc getKhoaHocById(String maKhoaHoc) {
        if (maKhoaHoc != null) {
            try {
                if (Integer.parseInt(maKhoaHoc) > -1) {
                    for (KhoaHoc x : _lstKhoaHocs) {
                        if (x.getMaKhoaHoc().equals(maKhoaHoc)) {
                            return x;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Mã khóa học không phải là một số!");
                e.printStackTrace();
            }
        }
        return null;
    }
    
    @Override
    public boolean removeKhoaHoc(KhoaHoc khoaHoc) {
        if (khoaHoc != null) {
            if (getKhoaHocById(khoaHoc.getMaKhoaHoc()) != null) {
                if (_daoKhoaHoc.delete(khoaHoc.getMaKhoaHoc())) {
                    _lstKhoaHocs.remove(khoaHoc);
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public List<KhoaHoc> getListKhoaHocByIdChuyenDe(String maChuyenDe) {
        List<KhoaHoc> lst = new ArrayList<>();
        for (KhoaHoc x : _lstKhoaHocs) {
            if (x.getMaChuyenDe().equalsIgnoreCase(maChuyenDe)) {
                lst.add(x);
            }
        }
        return lst;
    }
    
    @Override
    public boolean addKhoaHoc(KhoaHoc khoaHoc) {
        if (khoaHoc != null) {
            if (getKhoaHocById(khoaHoc.getMaKhoaHoc()) == null) {
                if (_daoKhoaHoc.insert(khoaHoc)) {
                    khoaHoc.setMaKhoaHoc(_daoKhoaHoc.getIdentity() + "");
                    _lstKhoaHocs.add(khoaHoc);
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public boolean editKhoaHoc(KhoaHoc khoaHoc) {
        if (khoaHoc != null) {
            int index = getIndexKhoaHoc(khoaHoc.getMaKhoaHoc());
            if (index > -1) {
                if (_daoKhoaHoc.update(khoaHoc)) {
                    _lstKhoaHocs.set(index, khoaHoc);
                    return true;
                }
            }
        }
        return false;
    }
    
    private int getIndexKhoaHoc(String maKhoaHoc) {
        if (maKhoaHoc == null) {
            return -2;
        }
        for (int i = 0; i < _lstKhoaHocs.size(); i++) {
            if (maKhoaHoc.equals(_lstKhoaHocs.get(i).getMaKhoaHoc())) {
                return i;
            }
        }
        return -1;
    }
    
}
