package rmi;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import data.customerdata.CustomerDataServiceImpl;
import data.userdata.UserDataServiceImpl;
import dataservice.accountdataservice.AccountDataService;
import dataservice.accountdataservice.StartAccountDataService;
import dataservice.billdataservice.BillHelperDataService;
import dataservice.billdataservice.CashBillDataService;
import dataservice.billdataservice.CashItemDataService;
import dataservice.billdataservice.PayAndReceiveBillDataService;
import dataservice.billdataservice.PayAndReceiveItemDataService;
import dataservice.billdataservice.SalesAndPurchaseBillDataService;
import dataservice.billdataservice.SalesAndPurchaseItemDataService;
import dataservice.billdataservice.StockAlarmBillDataService;
import dataservice.billdataservice.StockGiftBillDataService;
import dataservice.billdataservice.StockLossBillDataService;
import dataservice.billdataservice.StockOverflowBillDataService;
import dataservice.customerdataservice.CustomerDataService;
import dataservice.logdataservice.LogDataService;
import dataservice.stockdataservice.SalesStrategyDataService;
import dataservice.stockdataservice.StockDataService;
import dataservice.userdataservice.UserDataService;
import po.AccountPO;
import po.BillCategory;
import po.BillState;
import po.CustomerPO;
import po.GoodsPO;
import po.LogPO;
import po.StartAccountPO;
import po.UserPO;
import po.UserRole;
import po_accountbill.CashBillPO;
import po_accountbill.CashItem;
import po_accountbill.PayAndReceiveBillPO;
import po_accountbill.PayAndReceiveItem;
import po_salesandpurchasebill.GoodsItem;
import po_salesandpurchasebill.SalesAndPurchaseBillPO;
import po_salesandpurchasebill.SalesStrategyPO;
import po_stockbill.StockAlarmBillPO;
import po_stockbill.StockGiftBillPO;
import po_stockbill.StockLossBillPO;
import po_stockbill.StockOverflowBillPO;

public class DataRemoteObject extends UnicastRemoteObject implements  
 UserDataService, CustomerDataService,
 StockDataService, LogDataService, 
 SalesStrategyDataService,
 AccountDataService, StartAccountDataService, 
 SalesAndPurchaseBillDataService, SalesAndPurchaseItemDataService, 
 StockAlarmBillDataService, StockGiftBillDataService, StockLossBillDataService, StockOverflowBillDataService,
 PayAndReceiveBillDataService, PayAndReceiveItemDataService, 
 CashBillDataService, CashItemDataService,
 BillHelperDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4029039744279087114L;
	private UserDataService userDataService;    
		private CustomerDataService customerDataService;
		private StockDataService stockDataService;
		private LogDataService logDataService;
		
		private AccountDataService accountDataService;
		private StartAccountDataService startAccountDataService;
		
		private BillHelperDataService billHelperDataService;
		
		private PayAndReceiveBillDataService payAndReceiveBillDataService;
		private PayAndReceiveItemDataService payAndReceiveItemDataService;
		private CashBillDataService cashBillDataService;
		private CashItemDataService cashItemDataService;
		
		private SalesAndPurchaseBillDataService salesAndPurchaseBillDataService;
		private SalesAndPurchaseItemDataService salesAndPurchaseItemDataService;
		
		private StockAlarmBillDataService stockAlarmBillDataService;
		private StockGiftBillDataService stockGiftBillDataService;
		private StockLossBillDataService stockLossBillDataService;
		private StockOverflowBillDataService stockOverflowBillDataService;
		
		private SalesStrategyDataService salesStrategyDataService;
		
		public DataRemoteObject() throws RemoteException {
			userDataService = new UserDataServiceImpl();
			customerDataService = new CustomerDataServiceImpl();
		}

		@Override
		public String getUserNewID(UserRole role) throws RemoteException {
			// TODO Auto-generated method stub
			return userDataService.getUserNewID(role);
		}
		
		@Override
		public UserPO searchUserByID(String id) throws RemoteException {
			// TODO Auto-generated method stub
			return userDataService.searchUserByID(id);
		}

		@Override
		public boolean deleteUser(String id) throws RemoteException {
			// TODO Auto-generated method stub
			return userDataService.deleteUser(id);
		}

		@Override
		public boolean updateUser(UserPO user, String id) throws RemoteException {
			// TODO Auto-generated method stub
			return userDataService.updateUser(user, id);
		}

		@Override
		public List<UserPO> searchUserByInfo(String field) throws RemoteException {
			// TODO Auto-generated method stub
			return userDataService.searchUserByInfo(field);
		}

		@Override
		public boolean addUser(UserPO user) throws RemoteException {
			// TODO Auto-generated method stub
			return userDataService.addUser(user);
		}

		@Override
		public String getCustomerNewID() throws RemoteException {
			// TODO Auto-generated method stub
			return customerDataService.getCustomerNewID();
		}

		@Override
		public CustomerPO searchCustomerByID(String id) throws RemoteException {
			// TODO Auto-generated method stub
			return customerDataService.searchCustomerByID(id);
		}

		@Override
		public List<CustomerPO> searchCustomerByInfo(String field) throws RemoteException {
			// TODO Auto-generated method stub
			return customerDataService.searchCustomerByInfo(field);
		}

		@Override
		public boolean addCustomer(CustomerPO customer) throws RemoteException {
			// TODO Auto-generated method stub
			return customerDataService.addCustomer(customer);
		}

		@Override
		public boolean deleteCustomer(String id) throws RemoteException {
			// TODO Auto-generated method stub
			return customerDataService.deleteCustomer(id);
		}

		@Override
		public boolean updateCustomer(CustomerPO customer, String id) throws RemoteException {
			// TODO Auto-generated method stub
			return customerDataService.updateCustomer(customer, id);
		}

		@Override
		public String getNewID(BillCategory category, Date date) throws RemoteException {
			// TODO Auto-generated method stub
			return billHelperDataService.getNewID(category, date);
		}

		@Override
		public boolean addCashItem(String billID, CashItem item) throws RemoteException {
			// TODO Auto-generated method stub
			return cashItemDataService.addCashItem(billID, item);
		}

		@Override
		public boolean deleteCashItem(String billID, String id) throws RemoteException {
			// TODO Auto-generated method stub
			return cashItemDataService.deleteCashItem(billID, id);
		}

		@Override
		public ArrayList<CashBillPO> searchCashBillByUserID(String userid) throws RemoteException {
			// TODO Auto-generated method stub
			return cashBillDataService.searchCashBillByUserID(userid);
		}

		@Override
		public CashBillPO searchCashBillByID(String id) throws RemoteException {
			// TODO Auto-generated method stub
			return cashBillDataService.searchCashBillByID(id);
		}

		@Override
		public ArrayList<String> searchCashBillByInfo(Date start, Date end, String OperatorId) throws RemoteException {
			// TODO Auto-generated method stub
			return cashBillDataService.searchCashBillByInfo(start, end, OperatorId);
		}

		@Override
		public boolean addCashBill(CashBillPO bill) throws RemoteException {
			// TODO Auto-generated method stub
			return cashBillDataService.addCashBill(bill);
		}

		@Override
		public boolean deleteCashBill(String id) throws RemoteException {
			// TODO Auto-generated method stub
			return cashBillDataService.deleteCashBill(id);
		}

		@Override
		public boolean addPayAndReceiveItem(String billID, PayAndReceiveItem item) throws RemoteException {
			// TODO Auto-generated method stub
			return payAndReceiveItemDataService.addPayAndReceiveItem(billID, item);
		}

		@Override
		public boolean deletePayAndReceiveItem(String billID, String id) throws RemoteException {
			// TODO Auto-generated method stub
			return payAndReceiveItemDataService.deletePayAndReceiveItem(billID, id);
		}

		@Override
		public boolean updatePayAndReceiveItem(String billID, String id, int updateLoc, String message)
				throws RemoteException {
			// TODO Auto-generated method stub
			return payAndReceiveItemDataService.updatePayAndReceiveItem(billID, id, updateLoc, message);
		}

		@Override
		public ArrayList<PayAndReceiveBillPO> searchPayAndReceiveBillByUserID(String userid) throws RemoteException {
			// TODO Auto-generated method stub
			return payAndReceiveBillDataService.searchPayAndReceiveBillByUserID(userid);
		}

		@Override
		public PayAndReceiveBillPO searchPayAndReceiveBillByID(BillCategory category, String id)
				throws RemoteException {
			// TODO Auto-generated method stub
			return payAndReceiveBillDataService.searchPayAndReceiveBillByID(category, id);
		}

		@Override
		public ArrayList<String> searchPayAndReceiveBillByInfo(Date start, Date end, BillCategory category,
				String CustomerID, String OperatorId) throws RemoteException {
			// TODO Auto-generated method stub
			return payAndReceiveBillDataService.searchPayAndReceiveBillByInfo(start, end, category, CustomerID, OperatorId);
		}

		@Override
		public boolean addPayAndReceiveBill(PayAndReceiveBillPO bill) throws RemoteException {
			// TODO Auto-generated method stub
			return payAndReceiveBillDataService.addPayAndReceiveBill(bill);
		}

		@Override
		public boolean deletePayAndReceiveBill(String id) throws RemoteException {
			// TODO Auto-generated method stub
			return payAndReceiveBillDataService.deletePayAndReceiveBill(id);
		}

		@Override
		public boolean updatePayAndReceiveBillState(BillState newState, String id) throws RemoteException {
			// TODO Auto-generated method stub
			return payAndReceiveBillDataService.updatePayAndReceiveBillState(newState, id);
		}

		@Override
		public ArrayList<StockOverflowBillPO> getAllStockOverflowBill() throws RemoteException {
			// TODO Auto-generated method stub
			return stockOverflowBillDataService.getAllStockOverflowBill();
		}

		@Override
		public StockOverflowBillPO searchStockOverflowBillByID(String id) throws RemoteException {
			// TODO Auto-generated method stub
			return stockOverflowBillDataService.searchStockOverflowBillByID(id);
		}

		@Override
		public ArrayList<String> searchStockOverflowBillByInfo(Date start, Date end, String OperatorId, String WareId)
				throws RemoteException {
			// TODO Auto-generated method stub
			return stockOverflowBillDataService.searchStockOverflowBillByInfo(start, end, OperatorId, WareId);
		}

		@Override
		public boolean addStockOverflowBill(StockOverflowBillPO bill) throws RemoteException {
			// TODO Auto-generated method stub
			return stockOverflowBillDataService.addStockOverflowBill(bill);
		}

		@Override
		public boolean deleteStockOverflowBill(String id) throws RemoteException {
			// TODO Auto-generated method stub
			return stockOverflowBillDataService.deleteStockOverflowBill(id);
		}

		@Override
		public boolean updateStockOverflowBillState(BillState newState, String id) throws RemoteException {
			// TODO Auto-generated method stub
			return stockOverflowBillDataService.updateStockOverflowBillState(newState, id);
		}

		@Override
		public boolean updateStockOverflowBill(StockOverflowBillPO bill, String update, String message)
				throws RemoteException {
			// TODO Auto-generated method stub
			return stockOverflowBillDataService.updateStockOverflowBill(bill, update, message);
		}

		@Override
		public ArrayList<StockLossBillPO> getAllStockLossBill() throws RemoteException {
			// TODO Auto-generated method stub
			return stockLossBillDataService.getAllStockLossBill();
		}

		@Override
		public StockLossBillPO searchStockLossBillByID(String id) throws RemoteException {
			// TODO Auto-generated method stub
			return stockLossBillDataService.searchStockLossBillByID(id);
		}

		@Override
		public ArrayList<String> searchStockLossBillByInfo(Date start, Date end, String OperatorId, String WareId)
				throws RemoteException {
			// TODO Auto-generated method stub
			return stockLossBillDataService.searchStockLossBillByInfo(start, end, OperatorId, WareId);
		}

		@Override
		public boolean addStockLossBill(StockLossBillPO bill) throws RemoteException {
			// TODO Auto-generated method stub
			return stockLossBillDataService.addStockLossBill(bill);
		}

		@Override
		public boolean deleteStockLossBill(String id) throws RemoteException {
			// TODO Auto-generated method stub
			return stockLossBillDataService.deleteStockLossBill(id);
		}

		@Override
		public boolean updateStockLossBillState(BillState newState, String id) throws RemoteException {
			// TODO Auto-generated method stub
			return stockLossBillDataService.updateStockLossBillState(newState, id);
		}

		@Override
		public boolean updateStockLossBill(StockLossBillPO bill, String update, String message) throws RemoteException {
			// TODO Auto-generated method stub
			return stockLossBillDataService.updateStockLossBill(bill, update, message);
		}

		@Override
		public ArrayList<StockGiftBillPO> getAllStockGiftBill() throws RemoteException {
			// TODO Auto-generated method stub
			return stockGiftBillDataService.getAllStockGiftBill();
		}

		@Override
		public StockGiftBillPO searchStockGiftBillByID(String id) throws RemoteException {
			// TODO Auto-generated method stub
			return stockGiftBillDataService.searchStockGiftBillByID(id);
		}

		@Override
		public ArrayList<String> searchStockGiftBillByInfo(Date start, Date end, String OperatorId, String WareId)
				throws RemoteException {
			// TODO Auto-generated method stub
			return stockGiftBillDataService.searchStockGiftBillByInfo(start, end, OperatorId, WareId);
		}

		@Override
		public boolean addStockGiftBill(StockGiftBillPO bill) throws RemoteException {
			// TODO Auto-generated method stub
			return stockGiftBillDataService.addStockGiftBill(bill);
		}

		@Override
		public boolean deleteStockGiftBill(String id) throws RemoteException {
			// TODO Auto-generated method stub
			return stockGiftBillDataService.deleteStockGiftBill(id);
		}

		@Override
		public boolean updateStockGiftBillState(BillState newState, String id) throws RemoteException {
			// TODO Auto-generated method stub
			return stockGiftBillDataService.updateStockGiftBillState(newState, id);
		}

		@Override
		public boolean updateStockGiftBill(StockGiftBillPO bill, String update, String message) throws RemoteException {
			// TODO Auto-generated method stub
			return stockGiftBillDataService.updateStockGiftBill(bill, update, message);
		}

		@Override
		public ArrayList<StockAlarmBillPO> getAllStockAlarmBill() throws RemoteException {
			// TODO Auto-generated method stub
			return stockAlarmBillDataService.getAllStockAlarmBill();
		}

		@Override
		public StockAlarmBillPO searchStockAlarmBillByID(String id) throws RemoteException {
			// TODO Auto-generated method stub
			return stockAlarmBillDataService.searchStockAlarmBillByID(id);
		}

		@Override
		public ArrayList<String> searchStockAlarmBillByInfo(Date start, Date end, String OperatorId, String WareId)
				throws RemoteException {
			// TODO Auto-generated method stub
			return stockAlarmBillDataService.searchStockAlarmBillByInfo(start, end, OperatorId, WareId);
		}

		@Override
		public boolean addStockAlarmBill(StockAlarmBillPO bill) throws RemoteException {
			// TODO Auto-generated method stub
			return stockAlarmBillDataService.addStockAlarmBill(bill);
		}

		@Override
		public boolean deleteStockAlarmBill(String id) throws RemoteException {
			// TODO Auto-generated method stub
			return stockAlarmBillDataService.deleteStockAlarmBill(id);
		}

		@Override
		public boolean updateStockAlarmBillState(BillState newState, String id) throws RemoteException {
			// TODO Auto-generated method stub
			return stockAlarmBillDataService.updateStockAlarmBillState(newState, id);
		}

		@Override
		public boolean addGoodsItem(String billID, GoodsItem goods) throws RemoteException {
			// TODO Auto-generated method stub
			return salesAndPurchaseItemDataService.addGoodsItem(billID, goods);
		}

		@Override
		public boolean deleteGoodsItem(String billID, String goodsid) throws RemoteException {
			// TODO Auto-generated method stub
			return salesAndPurchaseItemDataService.deleteGoodsItem(billID, goodsid);
		}

		@Override
		public boolean updateGoodsItem(String billID, String goodsid, int updateLoc, String message)
				throws RemoteException {
			// TODO Auto-generated method stub
			return salesAndPurchaseItemDataService.updateGoodsItem(billID, goodsid, updateLoc, message);
		}

		@Override
		public SalesAndPurchaseBillPO searchSalesAndPurchaseBillByID(BillCategory categoy, String id)
				throws RemoteException {
			// TODO Auto-generated method stub
			return salesAndPurchaseBillDataService.searchSalesAndPurchaseBillByID(categoy, id);
		}

		@Override
		public ArrayList<String> searchSalesAndPurchaseBillByInfo(Date start, Date end, BillCategory category,
				String CustomerID, String OperatorId, String WareId) throws RemoteException {
			// TODO Auto-generated method stub
			return salesAndPurchaseBillDataService.searchSalesAndPurchaseBillByInfo(start, end, category, CustomerID, OperatorId, WareId);
		}

		@Override
		public ArrayList<SalesAndPurchaseBillPO> getAllSalesAndPurchaseBill() throws RemoteException {
			// TODO Auto-generated method stub
			return salesAndPurchaseBillDataService.getAllSalesAndPurchaseBill();
		}

		@Override
		public boolean addSalesAndPurchaseBill(SalesAndPurchaseBillPO bill) throws RemoteException {
			// TODO Auto-generated method stub
			return salesAndPurchaseBillDataService.addSalesAndPurchaseBill(bill);
		}

		@Override
		public boolean deleteSalesAndPurchaseBill(String id) throws RemoteException {
			// TODO Auto-generated method stub
			return salesAndPurchaseBillDataService.deleteSalesAndPurchaseBill(id);
		}

		@Override
		public boolean updateSalesAndPurchaseBill(SalesAndPurchaseBillPO bill, String updateLoc, String message)
				throws RemoteException {
			// TODO Auto-generated method stub
			return salesAndPurchaseBillDataService.updateSalesAndPurchaseBill(bill, updateLoc, message);
		}

		@Override
		public boolean updateSalesAndPurchaseBillState(BillState newState, String id) throws RemoteException {
			// TODO Auto-generated method stub
			return salesAndPurchaseBillDataService.updateSalesAndPurchaseBillState(newState, id);
		}

		@Override
		public List<StartAccountPO> getAllStartAccount() throws RemoteException {
			// TODO Auto-generated method stub
			return startAccountDataService.getAllStartAccount();
		}

		@Override
		public boolean addStartAccount(StartAccountPO startAccount) throws RemoteException {
			// TODO Auto-generated method stub
			return startAccountDataService.addStartAccount(startAccount);
		}

		@Override
		public List<StartAccountPO> getAllAccount() throws RemoteException {
			// TODO Auto-generated method stub
			return startAccountDataService.getAllStartAccount();
		}

		@Override
		public AccountPO getAccountByName(String name) throws RemoteException {
			// TODO Auto-generated method stub
			return accountDataService.getAccountByName(name);
		}

		@Override
		public List<AccountPO> searchAccountByInfo(String field) throws RemoteException {
			// TODO Auto-generated method stub
			return accountDataService.searchAccountByInfo(field);
		}

		@Override
		public boolean addAccount(AccountPO account) throws RemoteException {
			// TODO Auto-generated method stub
			return accountDataService.addAccount(account);
		}

		@Override
		public boolean deleteAccount(String name) throws RemoteException {
			// TODO Auto-generated method stub
			return accountDataService.deleteAccount(name);
		}

		@Override
		public SalesStrategyPO searchSalesStrategyByID(String id) throws RemoteException {
			// TODO Auto-generated method stub
			return salesStrategyDataService.searchSalesStrategyByID(id);
		}

		@Override
		public Map<String, SalesStrategyPO> getAllSalesStrategy() throws RemoteException {
			// TODO Auto-generated method stub
			return salesStrategyDataService.getAllSalesStrategy();
		}

		@Override
		public boolean AddSalesStrategy(SalesStrategyPO strategy) throws RemoteException {
			// TODO Auto-generated method stub
			return salesStrategyDataService.AddSalesStrategy(strategy);
		}

		@Override
		public boolean deleteSalesStrategy(String id) throws RemoteException {
			// TODO Auto-generated method stub
			return salesStrategyDataService.deleteSalesStrategy(id);
		}

		@Override
		public ArrayList<LogPO> checkLog() throws RemoteException {
			// TODO Auto-generated method stub
			return logDataService.checkLog();
		}

		@Override
		public boolean addLog(LogPO log) throws RemoteException {
			// TODO Auto-generated method stub
			return logDataService.addLog(log);
		}

		@Override
		public GoodsPO searchGoodsByID(String id) throws RemoteException {
			// TODO Auto-generated method stub
			return stockDataService.searchGoodsByID(id);
		}

		@Override
		public List<GoodsPO> searchGoodsByInfo(String field) throws RemoteException {
			// TODO Auto-generated method stub
			return stockDataService.searchGoodsByInfo(field);
		}

		@Override
		public boolean addGoods(GoodsPO goods) throws RemoteException {
			// TODO Auto-generated method stub
			return stockDataService.addGoods(goods);
		}

		@Override
		public boolean deleteGoods(String id) throws RemoteException {
			// TODO Auto-generated method stub
			return stockDataService.deleteGoods(id);
		}

		@Override
		public boolean updateGoods(GoodsPO goods, String id) throws RemoteException {
			// TODO Auto-generated method stub
			return stockDataService.updateGoods(goods, id);
		}
}
