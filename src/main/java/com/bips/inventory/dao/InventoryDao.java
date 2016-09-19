package com.bips.inventory.dao;

import java.util.List;

import com.bips.inventory.beans.InventoryGetBean;
import com.bips.inventory.beans.InventorySetBean;

public interface InventoryDao {
 public List<InventoryGetBean> getAllItems();
 public void submitItems(InventoryGetBean inventoryitems);
 public void addItems(InventorySetBean inventoryitems);
}
