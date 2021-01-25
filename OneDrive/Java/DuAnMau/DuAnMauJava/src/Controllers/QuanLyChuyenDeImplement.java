/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.DAOChuyenDe;
import Models.ChuyenDe;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NgocPJa
 */
public class QuanLyChuyenDeImplement implements QuanLyChuyenDe {

    private final DAOChuyenDe _daoChuyenDe = new DAOChuyenDe();
    private List<ChuyenDe> _lstChuyenDe = null;

    public QuanLyChuyenDeImplement() {
        _lstChuyenDe = new ArrayList<>();
        _lstChuyenDe = _daoChuyenDe.selectAll();
    }

    @Override
    public List<ChuyenDe> getListChuyenDe() {
        return _lstChuyenDe;
    }

    @Override
    public ChuyenDe getChuyenDeById(String maChuyenDe) {
        if (maChuyenDe != null) {
            for (ChuyenDe x : _lstChuyenDe) {
                if (x.getMaChuyenDe().equalsIgnoreCase(maChuyenDe)) {
                    return x;
                }
            }
        }
        return null;
    }

    @Override
    public boolean addChuyenDe(ChuyenDe cd) {
        if (cd != null) {
            if (getChuyenDeById(cd.getMaChuyenDe()) == null) {
                if (_daoChuyenDe.insert(cd)) {
                    _lstChuyenDe.add(cd);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean editChuyenDe(ChuyenDe cd) {
        if (cd != null) {
            int indexChuyenDe = getIndexChuyenDe(cd.getMaChuyenDe());
            if (indexChuyenDe > -1) {
                if (_daoChuyenDe.update(cd)) {
                    _lstChuyenDe.set(indexChuyenDe, cd);
                    return true;
                }
            }
        }
        return false;
    }

    private int getIndexChuyenDe(String maChuyenDe) {
        if (maChuyenDe == null) {
            return -2;
        }
        for (int i = 0; i < _lstChuyenDe.size(); i++) {
            if (maChuyenDe.equalsIgnoreCase(_lstChuyenDe.get(i).getMaChuyenDe())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean removeChuyenDe(ChuyenDe cd) {
        if (cd != null) {
            if (getChuyenDeById(cd.getMaChuyenDe()) != null) {
                if (_daoChuyenDe.delete(cd.getMaChuyenDe())) {
                    _lstChuyenDe.remove(cd);
                    return true;
                }
            }
        }
        return false;
    }

}
