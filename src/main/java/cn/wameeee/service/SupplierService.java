package cn.wameeee.service;

import cn.wameeee.entity.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> findList(Supplier supplier);
}
