package com.bips.inventory.dao;

import java.util.List;

import com.bips.inventory.beans.InventoryBeanModel;

public interface InventoryDao {
 public List<InventoryBeanModel> getAllItems();
 public void setItems(InventoryBeanModel inventoryitems);
}
