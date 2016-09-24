package com.bips.inventory.dao;

import java.util.List;

import com.bips.inventory.beans.InventoryFetchBean;
import com.bips.inventory.beans.InventoryGetBean;
import com.bips.inventory.beans.InventorySetBean;

public interface InventoryDao {
 public List<InventoryFetchBean> getAllItems();
 public String submitItems(InventoryGetBean inventoryitems);
 public String addItems(InventorySetBean inventoryitems);
}
