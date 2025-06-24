package cn.wameeee.mapper;

import cn.wameeee.entity.Supplier;

import java.util.List;

public interface SupplierMapper {

    /**
     * 查询供货商信息
     * @param supplier
     * @return
     */
    List<Supplier> getSupplierList(Supplier supplier);
}
