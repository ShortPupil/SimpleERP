package rmi;
import java.rmi.Remote;

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
import dataservice.stockdataservice.GoodsClassificationDataService;
import dataservice.stockdataservice.SalesStrategyDataService;
import dataservice.stockdataservice.StockDataService;
import dataservice.userdataservice.UserDataService;
public class RemoteHelper {
	private Remote remote;
	private static RemoteHelper remoteHelper = new RemoteHelper();
	public static RemoteHelper getInstance(){
		return remoteHelper;
	}
	
	public void setRemote(Remote remote){
		this.remote = remote;
	}
	
	
	public UserDataService getUserDataService(){
		return (UserDataService)remote;
	}
	
	public CustomerDataService getCustomerDataService(){
		return (CustomerDataService)remote;
	}

	public LogDataService getLogDataService() {
		return (LogDataService)remote;
	}
	public StockDataService getStockDataService() {
		return (StockDataService)remote;
	}
	public GoodsClassificationDataService getGoodsClassificationDataService() {
		return (GoodsClassificationDataService)remote;
	}
	public StartAccountDataService getStartAccountDataService() {
		return (StartAccountDataService)remote;
	}
	public AccountDataService getAccountDataService() {
		return (AccountDataService)remote;
	}
	public PayAndReceiveBillDataService getPayAndReceiveBillDataService() {
		return (PayAndReceiveBillDataService)remote;
	}
	public PayAndReceiveItemDataService getPayAndReceiveItemDataService() {
		return (PayAndReceiveItemDataService)remote;
	}
	public CashBillDataService getCashBillDataService() {
		return (CashBillDataService)remote;
	}
	public CashItemDataService getCashItemDataService() {
		return (CashItemDataService)remote;
	}
	public SalesAndPurchaseBillDataService getSalesAndPurchaseBillDataService() {
		return (SalesAndPurchaseBillDataService)remote;
	}
	public SalesAndPurchaseItemDataService getSalesAndPurchaseItemDataService() {
		return (SalesAndPurchaseItemDataService)remote;
	}
	public SalesStrategyDataService getSalesStrategyDataService() {
		return (SalesStrategyDataService)remote;
	}
	public StockAlarmBillDataService getStockAlarmBillDataService() {
		return (StockAlarmBillDataService)remote;
	}
	public StockGiftBillDataService getStockGiftBillDataService() {
		return (StockGiftBillDataService)remote;
	}
	public StockLossBillDataService getStockLossBillDataService() {
		return (StockLossBillDataService)remote;
	}
	public StockOverflowBillDataService getStockOverflowBillDataService() {
		return (StockOverflowBillDataService)remote;
	}
	public BillHelperDataService getBillHelperDataService() {
		return (BillHelperDataService)remote;
	}
}
