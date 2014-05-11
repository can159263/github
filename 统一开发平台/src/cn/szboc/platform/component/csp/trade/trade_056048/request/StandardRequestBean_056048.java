package cn.szboc.platform.component.csp.trade.trade_056048.request;

import java.math.BigDecimal;

import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.MessageGetEnhance;
import cn.szboc.platform.component.msgbean.annotation.PadType;
import cn.szboc.platform.component.msgbean.annotation.To;
import cn.szboc.platform.component.msgbean.interseptor.buildin.BigDecimalAdjust100000TimesInterceptor;
import cn.szboc.platform.component.msgbean.interseptor.buildin.BigDecimalAdjust100TimesInterceptor;

@MessageBean(Target = To.TO_BYTES, ExpectedReadSize = 1184)
public class StandardRequestBean_056048 extends RequestAdapter_056048 {

	/**
	 * 设置扣账账号,转账时与汇款人账号一致，代理转汇时可以与汇款人账号不同
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 300, length = 18)
	public String getUpAccountOut() {
		return super.getUpAccountOut();
	}

	/**
	 * 设置兑换金额,格式为9(14)V99，若没有外币兑换则与汇款金额相同 该字段要求上送的格式为左侧补0,不需要小数点,默认2位有效小数
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 318, length = 16, type = PadType.LEFT, material = 48)
	@MessageGetEnhance(beforeGet = BigDecimalAdjust100TimesInterceptor.class)
	public BigDecimal getUpCusAmtStr() {
		return super.getUpCusAmtStr();
	}

	/**
	 * 设置提示码
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 334, length = 2)
	public String getUpPromptCode() {
		return super.getUpPromptCode();
	}

	/**
	 * 设置转汇/落地账号
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 336, length = 18)
	public String getUpAccountIn() {
		return super.getUpAccountIn();
	}

	/**
	 * 设置转汇/落地账号所属系统
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 354, length = 3)
	public String getUpAccountInSystemType() {
		return super.getUpAccountInSystemType();
	}

	/**
	 * 设置转汇落地账号名称
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 357, length = 60)
	public String getUpAccountInName() {
		return super.getUpAccountInName();
	}

	/**
	 * 兑换货币,必须与扣款账户货币保持一致
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 417, length = 3)
	public String getUpExchangeCurrencyNo() {
		return super.getUpExchangeCurrencyNo();
	}

	/**
	 * 汇款金额, 9(14)V99
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 420, length = 16, type = PadType.LEFT, material = 48)
	@MessageGetEnhance(beforeGet = BigDecimalAdjust100TimesInterceptor.class)
	public BigDecimal getUpStrAmt() {
		return super.getUpStrAmt();
	}

	/**
	 * 汇款货币,如果转汇落地账号不为空，则必须与转汇落地账户货币保持一致
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 436, length = 3)
	public String getUpCurrencyNo() {
		return super.getUpCurrencyNo();
	}

	/**
	 * 本币金额,9(14)V99
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 439, length = 16, type = PadType.LEFT, material = 48)
	@MessageGetEnhance(beforeGet = BigDecimalAdjust100TimesInterceptor.class)
	public BigDecimal getUpLocalCurrencyAmt() {
		return super.getUpLocalCurrencyAmt();
	}

	/**
	 * 汇率类型,01现钞（默认值）,02现汇 指汇入方账号汇率类型，涉及外币时为必输
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 455, length = 2)
	public String getUpRateTypeIn() {
		return super.getUpRateTypeIn();
	}

	/**
	 * 汇率,指兑换货币与人民币的兑换汇率
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 457, length = 9, type = PadType.LEFT, material = 48)
	@MessageGetEnhance(beforeGet = BigDecimalAdjust100000TimesInterceptor.class)
	public BigDecimal getUpExchangeRate() {
		return super.getUpExchangeRate();
	}

	/**
	 * 业务性质 0：人民币 1：对公贸易 2：对私贸易 3：对公非贸易 4：对私非贸易 5：对公资本 6：对私资本
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 466, length = 1)
	public String getUpBusProperty() {
		return super.getUpBusProperty();
	}

	/**
	 * 汇款方式: 'R'：实时汇款 'S'：证券类汇款 'B'：退汇
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 467, length = 1)
	public String getUpTransferMode() {
		return super.getUpTransferMode();
	}

	/**
	 * 汇出资金来源 'T'：转帐（Transfer）， 'C'：现金（Cash） 'R'：代理转汇（Redirect Transfer）
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 468, length = 1)
	public String getUpSource() {
		return super.getUpSource();
	}

	/**
	 * 汇入去向: '1'：行内客户 '2'：行内非客户（无账户客户）。 '3'：转汇/落地
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 469, length = 1)
	public String getUpTransferDestination() {
		return super.getUpTransferDestination();
	}

	/**
	 * 设置报文类型
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 470, length = 6)
	public String getUpMessageType() {
		return super.getUpMessageType();
	}

	/**
	 * 汇率,指汇款货币与人民币的兑换汇率
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 476, length = 9, type = PadType.LEFT, material = 48)
	@MessageGetEnhance(beforeGet = BigDecimalAdjust100000TimesInterceptor.class)
	public BigDecimal getUpRate() {
		return super.getUpRate();
	}

	/**
	 * 扣款账号币种: 如果汇出资金来源不是现金，则此栏位必输，当为转帐时，与汇款人账号相同，当为代理转汇时可与汇款人账号不同
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 485, length = 3)
	public String getUpLinkCurrencyNo() {
		return super.getUpLinkCurrencyNo();
	}

	/**
	 * 扣款账号所属系统: DEP:存款账户 GEN:BGL账户
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 488, length = 3)
	public String getUpDeductAccountSystemType() {
		return super.getUpDeductAccountSystemType();
	}

	/**
	 * 汇款人账号,在代理转汇时，汇款人账号为名义付款人账号，扣款账号为实际扣款账号
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 491, length = 32)
	public String getUpApplyAccountNo() {
		return super.getUpApplyAccountNo();
	}

	/**
	 * 汇款人账号所属系统:如果汇款人账号不为空，则此栏位为必输，且当汇出资金来源为转账时，不能选择EXT DEP:存款账户 GEN:BGL账户
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 523, length = 3)
	public String getUpPayerSystemType() {
		return super.getUpPayerSystemType();
	}

	/**
	 * 汇款人账号名称 如果有账号名称就取账号名称，如果没有账户名称则取客户名称
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 526, length = 60)
	public String getUpApplyName() {
		return super.getUpApplyName();
	}

	/**
	 * 汇款人地址及电话
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 586, length = 80)
	public String getUpPayerInfo() {
		return super.getUpPayerInfo();
	}

	/**
	 * 存折标识,汇出资金来源＝转账时为必选项。有效值为： 'N'：无折。默认值 'Y'：有折
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 666, length = 1)
	public String getUpPassbkFlag() {
		return super.getUpPassbkFlag();
	}

	/**
	 * 支取方式
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 667, length = 1)
	public String getUpWithdrawType() {
		return super.getUpWithdrawType();
	}

	/**
	 * 校验标识 'Y'：核验通过 'N'：核验不通过
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 668, length = 1)
	public String getUpCheckFlag() {
		return super.getUpCheckFlag();
	}

	/**
	 * 凭证签发日期
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 669, length = 8)
	public String getUpOpenDate() {
		return super.getUpOpenDate();
	}

	/**
	 * 转汇落地账户币种,当转汇落地账号不为空时，此栏位必输
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 677, length = 3)
	public String getUpRecCurNo() {
		return super.getUpRecCurNo();
	}

	/**
	 * 汇款人证件号
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 680, length = 20)
	public String getUpPassno() {
		return super.getUpPassno();
	}

	/**
	 * 收款人帐号,只有在汇款去向为行内客户时为必输项
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 700, length = 32)
	public String getUpBenefitAcct() {
		return super.getUpBenefitAcct();
	}

	/**
	 * 收款人账号所属系统,如果收款人账号不为空，则此栏位必输，且汇款去向为行内客户时，不能选择EXT DEP:存款账户 GEN:BGL账户
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 732, length = 3)
	public String getUpRecnoSys() {
		return super.getUpRecnoSys();
	}

	/**
	 * 收款人名称,如果有收款人账户名称就取账户名称，如果没有则取客户名称
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 735, length = 60)
	public String getUpBenefitName() {
		return super.getUpBenefitName();
	}

	/**
	 * 收款人证件号
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 795, length = 20)
	public String getUpRecPassno() {
		return super.getUpRecPassno();
	}

	/**
	 * 原汇款编号,只有退汇时使用
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 815, length = 16)
	public String getUpChqNo() {
		return super.getUpChqNo();
	}

	/**
	 * 备注
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 831, length = 110)
	public String getUpStatNar() {
		return super.getUpStatNar();
	}

	/**
	 * 子账户类别, 只用于一本通账户
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 941, length = 4)
	public String getUpSubAccountType() {
		return super.getUpSubAccountType();
	}

	/**
	 * 产品类型, 只用于一本通账户
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 945, length = 4)
	public String getUpProdType() {
		return super.getUpProdType();
	}

	/**
	 * 产品子类, 只用于一本通账户
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 949, length = 4)
	public String getUpPcSubType() {
		return super.getUpPcSubType();
	}

	/**
	 * 业务类型,仅在‘系统标识’为‘B：小额支付系统’时为输入项。其他情况为隐藏栏位。
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 953, length = 5)
	public String getUpBusType() {
		return super.getUpBusType();
	}

	/**
	 * 汇入机构号,当转汇落地账号不为空时，取转汇落地账号所属机构号
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 958, length = 5)
	public String getUpSifOrgIdt() {
		return super.getUpSifOrgIdt();
	}

	/**
	 * 汇款用途 01：货款'。默认值。 02：运费' 03：现金' 04：劳务费/佣金' 05：借款' 06：还款'
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 963, length = 20)
	public String getUpPurRem() {
		return super.getUpPurRem();
	}

	/**
	 * 结售汇统计分析码,只有涉及兑换时才会使用
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 983, length = 6)
	public String getUpFcyexCode() {
		return super.getUpFcyexCode();
	}

	/**
	 * 申报核销标识,此选项只针对需要申报的业务才适用 'N'：不需要申报/核销。默认值 'D'：需要申报 'R'：需要核销
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 989, length = 1)
	public String getUpDeclareCancelFlag() {
		return super.getUpDeclareCancelFlag();
	}

	/**
	 * 凭证类型 0000：非重空结算申请书 3001：清分机转账支票 3003：转账支票 3004：普通支票 3005：驻华机构人民币支票
	 * 3006：驻华机构
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 990, length = 4)
	public String getUpVouchType() {
		return super.getUpVouchType();
	}

	/**
	 * 凭证号码
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 994, length = 20)
	public String getUpVouchNo() {
		return super.getUpVouchNo();
	}

	/**
	 * 凭证支取方式 1：凭支付密码 2：电子印鉴 3：手工印鉴 4：密码 5：签字 6：无限制 8：一票一密
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 1014, length = 1)
	public String getUpVoucherDrawType() {
		return super.getUpVoucherDrawType();
	}

	/**
	 * 支付密码
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 1015, length = 16)
	public String getUpPayPassword() {
		return super.getUpPayPassword();
	}

	/**
	 * 收款人地址及电话
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 1031, length = 80)
	public String getUpPayeeInfo() {
		return super.getUpPayeeInfo();
	}

	/**
	 * 汇款人借记卡号
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 1111, length = 19)
	public String getUpCardNoOut() {
		return super.getUpCardNoOut();
	}

	/**
	 * 收款人借记卡号
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 1130, length = 19)
	public String getUpCardNoIn() {
		return super.getUpCardNoIn();
	}

	/**
	 * 联机批量标识,联机时不用赋值 空：联机 B：批量
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 1149, length = 1)
	public String getUpBatchFlag() {
		return super.getUpBatchFlag();
	}

	/**
	 * 汇率类型,汇出方账号汇率类型，涉及外币时必输 01现钞（默认值） 02现汇
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 1150, length = 2)
	public String getUpRateType() {
		return super.getUpRateType();
	}

	/**
	 * 扣款账户名称,如果有账户名称就取账户名称，如果没有则取客户名称
	 * 
	 * @return
	 */
	@Override
	@MessageField(startPos = 1152, length = 32)
	public String getUpPreservedField() {
		return super.getUpPreservedField();
	}

}
