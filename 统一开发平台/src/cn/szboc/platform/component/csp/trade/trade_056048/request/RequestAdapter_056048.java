package cn.szboc.platform.component.csp.trade.trade_056048.request;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.szboc.platform.component.csp.exception.QueryResultException;
import cn.szboc.platform.component.csp.exception.QueryResultFailureException;
import cn.szboc.platform.component.csp.exception.RequestBuildingException;
import cn.szboc.platform.component.csp.exception.RollbackWarningException;
import cn.szboc.platform.component.csp.requestbuilder.CommonRequest;
import cn.szboc.platform.component.csp.trade.commons.TradeCode;
import cn.szboc.platform.component.csp.trade.commons.TradeStatus;
import cn.szboc.platform.component.csp.trade.commons.response.CspTradeResult;
import cn.szboc.platform.component.csp.trade.commons.response.ExecuteResponse;
import cn.szboc.platform.component.csp.trade.trade_056048.response.ResponseAdapter_056048;
import cn.szboc.platform.component.csp.trade.trade_056048.response.StandardResponseBean_056048;
import cn.szboc.platform.component.csp.trade.trade_056148.response.StandardResponseBean_056148;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 对于056048交易的所有请求字段的GET方法的抽象
 */
@MessageBean(Target = To.TO_BYTES, ExpectedReadSize = 1184)
public abstract class RequestAdapter_056048 extends CommonRequest<ResponseAdapter_056048, StandardResponseBean_056048> {

	private static Logger _logger = LoggerFactory.getLogger(RequestAdapter_056048.class);
	
	// ===========================上送数据域(共54个栏位)=============================
	/** 扣款账号(M) */
	private String upAccountOut;
	/** 兑换金额(M) */
	private BigDecimal upCusAmtStr;
	/** 提示码 (M) */
	private String upPromptCode;
	/** 转汇/落地账号 */
	private String upAccountIn;
	/** 转汇/落地账号所属系统 */
	private String upAccountInSystemType;
	/** 转汇/落地账号名称 */
	private String upAccountInName;
	/** 兑换币别 */
	private String upExchangeCurrencyNo;
	/** 汇款金额 */
	private BigDecimal upStrAmt;
	/** 汇款币别 */
	private String upCurrencyNo;
	/** 本币金额 */
	private BigDecimal upLocalCurrencyAmt;
	/** 汇率类型 */
	private String upRateTypeIn;
	/** 汇率(兑换货币与人民币) */
	private BigDecimal upExchangeRate;
	/** 业务性质 */
	private String upBusProperty;
	/** 汇款方式 */
	private String upTransferMode;
	/** 汇出资金来源 */
	private String upSource;
	/** 汇入去向 */
	private String upTransferDestination;
	/** 报文类型 */
	private String upMessageType;
	/** 汇率(汇款货币与人民币) */
	private BigDecimal upRate;
	/** 扣款账号币种 */
	private String upLinkCurrencyNo;
	/** 扣款账号所属系统 */
	private String upDeductAccountSystemType;
	/** 汇款人账号 */
	private String upApplyAccountNo;
	/** 汇款人账号所属系统 */
	private String upPayerSystemType;
	/** 汇款人账号名称 */
	private String upApplyName;
	/** 汇款人地址及电话 */
	private String upPayerInfo;
	/** 存折标识 */
	private String upPassbkFlag;
	/** 支取方式 */
	private String upWithdrawType;
	/** 校验标识 */
	private String upCheckFlag;
	/** 凭证签发日期 */
	private String upOpenDate;
	/** 转汇落地账户币种 */
	private String upRecCurNo;
	/** 汇款人证件号 */
	private String upPassno;
	/** 收款人帐号 */
	private String upBenefitAcct;
	/** 收款人账号所属系统 */
	private String upRecnoSys;
	/** 收款人名称 */
	private String upBenefitName;
	/** 收款人证件号 */
	private String upRecPassno;
	/** 原汇款编号 */
	private String upChqNo;
	/** 备注 */
	private String upStatNar;
	/** 子账户类别 */
	private String upSubAccountType;
	/** 产品类型 */
	private String upProdType;
	/** 产品子类 */
	private String upPcSubType;
	/** 业务类型 */
	private String upBusType;
	/** 汇入机构号 */
	private String upSifOrgIdt;
	/** 汇款用途 */
	private String upPurRem;
	/** 结售汇统计分析码 */
	private String upFcyexCode;
	/** 申报核销标识 */
	private String upDeclareCancelFlag;
	/** 凭证类型 */
	private String upVouchType;
	/** 凭证号码 */
	private String upVouchNo;
	/** 凭证支取方式 */
	private String upVoucherDrawType;
	/** 支付密码 */
	private String upPayPassword;
	/** 收款人地址及电话 */
	private String upPayeeInfo;
	/** 汇款人借记卡号 */
	private String upCardNoOut;
	/** 收款人借记卡号 */
	private String upCardNoIn;
	/** 联机批量标识 */
	private String upBatchFlag;
	/** 汇率类型 */
	private String upRateType;
	/** 预留 */
	private String upPreservedField;

	// ======================================================================

	@Override
	protected TradeCode withTradeCode() {
		return TradeCode.TRADE_056048;
	}

	public String getUpAccountOut() {
		return upAccountOut;
	}

	public BigDecimal getUpCusAmtStr() {
		return upCusAmtStr;
	}

	public String getUpPromptCode() {
		return upPromptCode;
	}

	public String getUpAccountIn() {
		return upAccountIn;
	}

	public String getUpAccountInSystemType() {
		return upAccountInSystemType;
	}

	public String getUpAccountInName() {
		return upAccountInName;
	}

	public String getUpExchangeCurrencyNo() {
		return upExchangeCurrencyNo;
	}

	public BigDecimal getUpStrAmt() {
		return upStrAmt;
	}

	public String getUpCurrencyNo() {
		return upCurrencyNo;
	}

	public BigDecimal getUpLocalCurrencyAmt() {
		return upLocalCurrencyAmt;
	}

	public String getUpRateTypeIn() {
		return upRateTypeIn;
	}

	public BigDecimal getUpExchangeRate() {
		return upExchangeRate;
	}

	public String getUpBusProperty() {
		return upBusProperty;
	}

	public String getUpTransferMode() {
		return upTransferMode;
	}

	public String getUpSource() {
		return upSource;
	}

	public String getUpTransferDestination() {
		return upTransferDestination;
	}

	public String getUpMessageType() {
		return upMessageType;
	}

	public BigDecimal getUpRate() {
		return upRate;
	}

	public String getUpLinkCurrencyNo() {
		return upLinkCurrencyNo;
	}

	public String getUpDeductAccountSystemType() {
		return upDeductAccountSystemType;
	}

	public String getUpApplyAccountNo() {
		return upApplyAccountNo;
	}

	public String getUpPayerSystemType() {
		return upPayerSystemType;
	}

	public String getUpApplyName() {
		return upApplyName;
	}

	public String getUpPayerInfo() {
		return upPayerInfo;
	}

	public String getUpPassbkFlag() {
		return upPassbkFlag;
	}

	public String getUpWithdrawType() {
		return upWithdrawType;
	}

	public String getUpCheckFlag() {
		return upCheckFlag;
	}

	public String getUpOpenDate() {
		return upOpenDate;
	}

	public String getUpRecCurNo() {
		return upRecCurNo;
	}

	public String getUpPassno() {
		return upPassno;
	}

	public String getUpBenefitAcct() {
		return upBenefitAcct;
	}

	public String getUpRecnoSys() {
		return upRecnoSys;
	}

	public String getUpBenefitName() {
		return upBenefitName;
	}

	public String getUpRecPassno() {
		return upRecPassno;
	}

	public String getUpChqNo() {
		return upChqNo;
	}

	public String getUpStatNar() {
		return upStatNar;
	}

	public String getUpSubAccountType() {
		return upSubAccountType;
	}

	public String getUpProdType() {
		return upProdType;
	}

	public String getUpPcSubType() {
		return upPcSubType;
	}

	public String getUpBusType() {
		return upBusType;
	}

	public String getUpSifOrgIdt() {
		return upSifOrgIdt;
	}

	public String getUpPurRem() {
		return upPurRem;
	}

	public String getUpFcyexCode() {
		return upFcyexCode;
	}

	public String getUpDeclareCancelFlag() {
		return upDeclareCancelFlag;
	}

	public String getUpVouchType() {
		return upVouchType;
	}

	public String getUpVouchNo() {
		return upVouchNo;
	}

	public String getUpVoucherDrawType() {
		return upVoucherDrawType;
	}

	public String getUpPayPassword() {
		return upPayPassword;
	}

	public String getUpPayeeInfo() {
		return upPayeeInfo;
	}

	public String getUpCardNoOut() {
		return upCardNoOut;
	}

	public String getUpCardNoIn() {
		return upCardNoIn;
	}

	public String getUpBatchFlag() {
		return upBatchFlag;
	}

	public String getUpRateType() {
		return upRateType;
	}

	public String getUpPreservedField() {
		return upPreservedField;
	}

	/**
	 * 栏位:19 扣款账号
	 * 
	 * @param upAccountOut
	 * @return
	 */
	public RequestAdapter_056048 setUpAccountOut(String upAccountOut) {
		this.upAccountOut = upAccountOut;
		return this;
	}

	/**
	 * 栏位:20 兑换金额
	 * 
	 * @param upCusAmtStr
	 * @return
	 */
	public RequestAdapter_056048 setUpCusAmtStr(BigDecimal upCusAmtStr) {
		this.upCusAmtStr = upCusAmtStr;
		return this;
	}

	/**
	 * 栏位:21 提示码
	 * 
	 * @param upPromptCode
	 * @return
	 */
	public RequestAdapter_056048 setUpPromptCode(String upPromptCode) {
		this.upPromptCode = upPromptCode;
		return this;
	}

	/**
	 * 栏位:22 转汇/落地账号
	 * 
	 * @param upAccountIn
	 * @return
	 */
	public RequestAdapter_056048 setUpAccountIn(String upAccountIn) {
		this.upAccountIn = upAccountIn;
		return this;
	}

	/**
	 * 栏位:23 转汇/落地账号所属系统
	 * 
	 * @param upAccountInSystemType
	 * @return
	 */
	public RequestAdapter_056048 setUpAccountInSystemType(String upAccountInSystemType) {
		this.upAccountInSystemType = upAccountInSystemType;
		return this;
	}

	/**
	 * 栏位:24 转汇/落地账号名称
	 * 
	 * @param upAccountInName
	 * @return
	 */
	public RequestAdapter_056048 setUpAccountInName(String upAccountInName) {
		this.upAccountInName = upAccountInName;
		return this;
	}

	/**
	 * 栏位:25,[必填] 兑换币别
	 * 
	 * @param upExchangeCurrencyNo
	 * @return
	 */
	public RequestAdapter_056048 setUpExchangeCurrencyNo(String upExchangeCurrencyNo) {
		this.upExchangeCurrencyNo = upExchangeCurrencyNo;
		return this;
	}

	/**
	 * 栏位:26,[必填] 汇款金额
	 * 
	 * @param upStrAmt
	 * @return
	 */
	public RequestAdapter_056048 setUpStrAmt(BigDecimal upStrAmt) {
		this.upStrAmt = upStrAmt;
		return this;
	}

	/**
	 * 栏位:27,[必填] 汇款币别
	 * 
	 * @param upCurrencyNo
	 * @return
	 */
	public RequestAdapter_056048 setUpCurrencyNo(String upCurrencyNo) {
		this.upCurrencyNo = upCurrencyNo;
		return this;
	}

	/**
	 * 栏位:28,[必填] 本币金额
	 * 
	 * @param upLocalCurrencyAmt
	 * @return
	 */
	public RequestAdapter_056048 setUpLocalCurrencyAmt(BigDecimal upLocalCurrencyAmt) {
		this.upLocalCurrencyAmt = upLocalCurrencyAmt;
		return this;
	}

	/**
	 * 栏位:31,[非必填] 汇率类型: 01-现钞（默认值）;02-现汇
	 * 
	 * @param upRateTypeIn
	 * @return
	 */
	public RequestAdapter_056048 setUpRateTypeIn(String upRateTypeIn) {
		this.upRateTypeIn = upRateTypeIn;
		return this;
	}

	/**
	 * 栏位:32,[必填] 汇率
	 * 
	 * @param upExchangeRate
	 * @return
	 */
	public RequestAdapter_056048 setUpExchangeRate(BigDecimal upExchangeRate) {
		this.upExchangeRate = upExchangeRate;
		return this;
	}

	/**
	 * 栏位:33,[必填] 业务性质 0：人民币 1：对公贸易 2：对私贸易 3：对公非贸易 4：对私非贸易 5：对公资本 6：对私资本
	 * 
	 * @param upBusProperty
	 * @return
	 */
	public RequestAdapter_056048 setUpBusProperty(String upBusProperty) {
		this.upBusProperty = upBusProperty;
		return this;
	}

	/**
	 * 栏位:34,[必填] [必输]汇款方式 'R'：实时汇款 'S'：证券类汇款 'B'：退汇
	 * 
	 * @param upTransferMode
	 * @return
	 */
	public RequestAdapter_056048 setUpTransferMode(String upTransferMode) {
		this.upTransferMode = upTransferMode;
		return this;
	}

	/**
	 * 栏位:35,[必填] 汇出资金来源 'T'：转帐（Transfer）， 'C'：现金（Cash） 'R'：代理转汇（Redirect） 'A'：无介质个人户
	 * Transfer）
	 * 
	 * @param upSource
	 * @return
	 */
	public RequestAdapter_056048 setUpSource(String upSource) {
		this.upSource = upSource;
		return this;
	}

	/**
	 * 栏位:36,[必填] 汇入去向 '1'：行内客户 '2'：行内非客户（无账户客户）。 '3'：转汇/落地。
	 * 
	 * @param upTransferDestination
	 * @return
	 */
	public RequestAdapter_056048 setUpTransferDestination(String upTransferDestination) {
		this.upTransferDestination = upTransferDestination;
		return this;
	}

	/**
	 * 栏位:38,[非必填] 报文类型
	 * 
	 * @param upMessageType
	 * @return
	 */
	public RequestAdapter_056048 setUpMessageType(String upMessageType) {
		this.upMessageType = upMessageType;
		return this;
	}

	/**
	 * 栏位:39,[必填] 汇率 转换时自动扩大100000倍
	 * 
	 * @param upRate
	 * @return
	 */
	public RequestAdapter_056048 setUpRate(BigDecimal upRate) {
		this.upRate = upRate;
		return this;
	}

	/**
	 * 栏位:40,[必填] 扣款账号币种
	 * 
	 * @param upLinkCurrencyNo
	 * @return
	 */
	public RequestAdapter_056048 setUpLinkCurrencyNo(String upLinkCurrencyNo) {
		this.upLinkCurrencyNo = upLinkCurrencyNo;
		return this;
	}

	/**
	 * 栏位:41,[必填] 扣款账号所属系统
	 * 
	 * @param upDeductAccountSystemType
	 * @return
	 */
	public RequestAdapter_056048 setUpDeductAccountSystemType(String upDeductAccountSystemType) {
		this.upDeductAccountSystemType = upDeductAccountSystemType;
		return this;
	}

	/**
	 * 栏位:42,[必填] 汇款人账号
	 * 
	 * @param upApplyAccountNo
	 * @return
	 */
	public RequestAdapter_056048 setUpApplyAccountNo(String upApplyAccountNo) {
		this.upApplyAccountNo = upApplyAccountNo;
		return this;
	}

	/**
	 * 栏位:43,[必填] 汇款人账号所属系统
	 * 
	 * @param upPayerSystemType
	 * @return
	 */
	public RequestAdapter_056048 setUpPayerSystemType(String upPayerSystemType) {
		this.upPayerSystemType = upPayerSystemType;
		return this;
	}

	public RequestAdapter_056048 setUpApplyName(String upApplyName) {
		this.upApplyName = upApplyName;
		return this;
	}

	public RequestAdapter_056048 setUpPayerInfo(String upPayerInfo) {
		this.upPayerInfo = upPayerInfo;
		return this;
	}

	/**
	 * 栏位:46,[必填] 存折标识 'N'：无折。默认值 'Y'：有折
	 * 
	 * @param upPassbkFlag
	 * @return
	 */
	public RequestAdapter_056048 setUpPassbkFlag(String upPassbkFlag) {
		this.upPassbkFlag = upPassbkFlag;
		return this;
	}

	public RequestAdapter_056048 setUpWithdrawType(String upWithdrawType) {
		this.upWithdrawType = upWithdrawType;
		return this;
	}

	public RequestAdapter_056048 setUpCheckFlag(String upCheckFlag) {
		this.upCheckFlag = upCheckFlag;
		return this;
	}

	public RequestAdapter_056048 setUpOpenDate(String upOpenDate) {
		this.upOpenDate = upOpenDate;
		return this;
	}

	/**
	 * 栏位:50,[必填] 转汇落地账号币种
	 * 
	 * @param upRecCurNo
	 * @return
	 */
	public RequestAdapter_056048 setUpRecCurNo(String upRecCurNo) {
		this.upRecCurNo = upRecCurNo;
		return this;
	}

	public RequestAdapter_056048 setUpPassno(String upPassno) {
		this.upPassno = upPassno;
		return this;
	}

	/**
	 * 栏位:52 [必输] 收款人账号
	 * 
	 * @param upBenefitAcct
	 * @return
	 */
	public RequestAdapter_056048 setUpBenefitAcct(String upBenefitAcct) {
		this.upBenefitAcct = upBenefitAcct;
		return this;
	}

	/**
	 * 栏位:53 [必输] 收款人账号所属系统
	 * 
	 * @param upBenefitAcct
	 * @return
	 */
	public RequestAdapter_056048 setUpRecnoSys(String upRecnoSys) {
		this.upRecnoSys = upRecnoSys;
		return this;
	}

	public RequestAdapter_056048 setUpBenefitName(String upBenefitName) {
		this.upBenefitName = upBenefitName;
		return this;
	}

	public RequestAdapter_056048 setUpRecPassno(String upRecPassno) {
		this.upRecPassno = upRecPassno;
		return this;
	}

	public RequestAdapter_056048 setUpChqNo(String upChqNo) {
		this.upChqNo = upChqNo;
		return this;
	}

	public RequestAdapter_056048 setUpStatNar(String upStatNar) {
		this.upStatNar = upStatNar;
		return this;
	}

	public RequestAdapter_056048 setUpSubAccountType(String upSubAccountType) {
		this.upSubAccountType = upSubAccountType;
		return this;
	}

	public RequestAdapter_056048 setUpProdType(String upProdType) {
		this.upProdType = upProdType;
		return this;
	}

	public RequestAdapter_056048 setUpPcSubType(String upPcSubType) {
		this.upPcSubType = upPcSubType;
		return this;
	}

	public RequestAdapter_056048 setUpBusType(String upBusType) {
		this.upBusType = upBusType;
		return this;
	}

	/**
	 * 栏位:62 [必输]汇入机构号
	 * 
	 * @param upSifOrgIdt
	 * @return
	 */
	public RequestAdapter_056048 setUpSifOrgIdt(String upSifOrgIdt) {
		this.upSifOrgIdt = upSifOrgIdt;
		return this;
	}

	public RequestAdapter_056048 setUpPurRem(String upPurRem) {
		this.upPurRem = upPurRem;
		return this;
	}

	public RequestAdapter_056048 setUpFcyexCode(String upFcyexCode) {
		this.upFcyexCode = upFcyexCode;
		return this;
	}

	/**
	 * 栏位:65 [必填] 申报核销标志 'N'：不需要申报/核销。默认值 'D'：需要申报 'R'：需要核销
	 * 
	 * @param upDeclareCancelFlag
	 * @return
	 */
	public RequestAdapter_056048 setUpDeclareCancelFlag(String upDeclareCancelFlag) {
		this.upDeclareCancelFlag = upDeclareCancelFlag;
		return this;
	}

	public RequestAdapter_056048 setUpVouchType(String upVouchType) {
		this.upVouchType = upVouchType;
		return this;
	}

	public RequestAdapter_056048 setUpVouchNo(String upVouchNo) {
		this.upVouchNo = upVouchNo;
		return this;
	}

	public RequestAdapter_056048 setUpVoucherDrawType(String upVoucherDrawType) {
		this.upVoucherDrawType = upVoucherDrawType;
		return this;
	}

	public RequestAdapter_056048 setUpPayPassword(String upPayPassword) {
		this.upPayPassword = upPayPassword;
		return this;
	}

	public RequestAdapter_056048 setUpPayeeInfo(String upPayeeInfo) {
		this.upPayeeInfo = upPayeeInfo;
		return this;
	}

	public RequestAdapter_056048 setUpCardNoOut(String upCardNoOut) {
		this.upCardNoOut = upCardNoOut;
		return this;
	}

	public RequestAdapter_056048 setUpCardNoIn(String upCardNoIn) {
		this.upCardNoIn = upCardNoIn;
		return this;
	}

	public RequestAdapter_056048 setUpBatchFlag(String upBatchFlag) {
		this.upBatchFlag = upBatchFlag;
		return this;
	}

	public RequestAdapter_056048 setUpRateType(String upRateType) {
		this.upRateType = upRateType;
		return this;
	}

	/**
	 * 栏位:75 预留
	 * 
	 * @param upPreservedField
	 * @return
	 */
	public RequestAdapter_056048 setUpPreservedField(String upPreservedField) {
		this.upPreservedField = upPreservedField;
		return this;
	}

	@Override
	protected void checkBeforeSend() throws RequestBuildingException {
		super.checkBeforeSend();
	}


	@Override
	public boolean isAccountOperationTrade() {
		return true;
	}
	
	/**
	 * 冲正交易,发送056148进行冲正
	 * @throws Exception 
	 */
	@Override
	public boolean rollback() throws Exception {

		if (this.responseBean == null) {
			throw new NullPointerException("交易未完成,请先明确交易结果再进行处理");
		}

		String seqNo = this.getCommonTransNo();
		
		/** 原交易属于重发,那么不应该把错误引用的交易也冲正 */
		final String CE05 = "CE05";
		/** 找不到原交易 */
		final String CE12 = "CE12";
		/** 原交易已经冲正 */
		final String CE11 = "CE11";
		
		switch (this.responseBean.getResult()) {
			case EXCEPTION_BEFORE_SEND:
				// 交易发生前就异常,冲正默认不执行任何操作
				return false;
			case TRADE_FAILURE:
				// 如果是返回"CE05(请求方流水号重复)",那么要特别注意,非常可能是由于传票流水号重复发送了,这里要抛出警告
				if(this.responseBean.getTradeResultBean().getCommonReturnCode().equals(CE05)){
					throw new RollbackWarningException(seqNo, CE05);
				}
				return false;
			case EXCEPTION_AFTER_SEND:
				// 先发查询
				TradeStatus status = null;
				try {
					status = this.queryRequestResult();
				} catch (QueryResultException e1) {
					throw new Exception("原交易状态不明,查询原交易结果时再次发生异常", e1);
				} catch (QueryResultFailureException e2) {
					throw new Exception("原交易状态不明,查询原交易结果时查询失败", e2);
				} catch (Exception e3) {
					throw new Exception("原交易状态不明,查询原交易结果时查询异常", e3);
				}
				// 如果到的交易查询结果是成功
				switch(status){
					// 原交易明确成功
					case SUCCESS:
						// 设置响应bean状态为成功
						this.responseBean.setResult(CspTradeResult.TRADE_SUCCESS);
						_rollback();
						return true;
					// 原交易不存在,证明交易未成功发送,则无须冲正
					case NOT_EXISTS:
						throw new RollbackWarningException(seqNo, CE12);
					// 原交易已经冲正过,无须再次冲正
					case ROLLBACK:
						throw new RollbackWarningException(seqNo, CE11);
					// 原交易状态不明确
					case NOT_EXPLICIT:
						throw new Exception("原交易结果经过查询,状态为[不明确],无法执行冲正");
					// 冲正失败,再冲一次
					case ROLLBACK_FAILURE:
						_rollback();
						return true;
					// 正在冲正中
					case ROLLBACKING:
						throw new Exception("原交易正在执行冲正,请稍后发起查询");
				}
			// 默认交易成功,允许冲正
			case TRADE_SUCCESS:
				_rollback();
				return true;
			default:
				throw new Exception("交易结果不明确!");
		}
	}
	
	/**
	 * 内部执行冲正的代码
	 */
	private void _rollback() throws Exception {
		
		ResponseAdapter_056048 responseBean = this.responseBean.getTradeResultBean();
		
		ExecuteResponse<StandardResponseBean_056148> response = null;

		response = factory.newRequestBuilder_056148()
				.newRequest(this.getCommonBranchNo(), this.getCommonOperator())
        		.setUpAccountOut(this.getUpAccountOut())
        		.setUpChqNo(responseBean.getDownIpcsCode())
        		.setUpCusAmtStr(this.getUpCusAmtStr())
        		.setUpPcCurrency(this.getUpExchangeCurrencyNo())
        		.setUpStrAmt(this.getUpStrAmt())
        		.setUpCurrencyNo(this.getUpCurrencyNo())
        		.setUpResultAmt(this.getUpLocalCurrencyAmt())
        		.setUpRevsTraceNo(responseBean.getCommonCspNo())
        		.build()
        		.send();
		
		// 冲正成功
		if (response.isTradeSuccess()) {
			return;
		}

		if (response.isTradeFailure()) {
			
			if("CE11".equals(response.getTradeResultBean().getCommonReturnCode())){
				_logger.error("冲正交易(原交易流水号{})返回CE11(已冲正,请勿重复冲正),属于为冲正警告");
				throw new RollbackWarningException(responseBean.getCommonCspNo(), "CE11");
			}
			
			if("CE12".equals(response.getTradeResultBean().getCommonReturnCode())){
				_logger.error("冲正交易(原交易流水号{})返回CE12(冲正记录未发现),属于为冲正警告");
				throw new RollbackWarningException(responseBean.getCommonCspNo(), "CE12");
			}
			
			throw new Exception("冲正交易失败,冲正交易返回码为" + response.getTradeResultBean().getCommonReturnCode());
		}

		throw new Exception("冲正交易发送失败", response.getThrowable());
	}
}
