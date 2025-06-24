package cn.wameeee.service.impl;

import cn.wameeee.entity.Supplier;
import cn.wameeee.mapper.SupplierMapper;
import cn.wameeee.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("supplierService")
@Transactional
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;
    public void setSupplierMapper(SupplierMapper supplierMapper) {this.supplierMapper = supplierMapper;}

    @Override
    public List<Supplier> findList(Supplier supplier) {
      return supplierMapper.getSupplierList(supplier);
    }
}
