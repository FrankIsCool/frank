package com.sxmaps.mms.utils;

/**
 * 订单模块 常量类
 * 
 * @author chendehua
 *
 */
public class ConstantUtil {
	/**
	 * 订单状态
	 * 
	 * @author chendehua
	 *
	 */
	public enum OrderState {
		CANECLED("CANCELED", "已取消"), UNPAID("UNPAID", "未付款"), PARTPAID("PARTPAID", "部分付款"), PAID("PAID",
				"已付款"), DEAL("DEAL", "已完成");

		private String state;
		private String desc;

		private OrderState(String state, String desc) {
			this.state = state;
			this.desc = desc;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
	}

	/**
	 * 订单服务状态
	 * 
	 * @author chendehua
	 *
	 */
	public enum OrderServiceState {
		REJECT("-1", "退费驳回"), REFUNDING("0", "退款申请中"), PARTREFUNDED("1", "部分退款"), REFUNDED("2", "全部退款");

		private String state;
		private String desc;

		private OrderServiceState(String state, String desc) {
			this.state = state;
			this.desc = desc;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
	}

	/**
	 * 支付方式
	 * 
	 * @author chendehua
	 *
	 */
	public enum PayWay {
		WXPAY("WXPAY", "微信支付"), ALIPAY("ALIPAY", "支付宝支付"), BAIDU("BAIDU", "百度分期"), CASH("CASH", "现金支付"), CARD("CARD",
				"刷卡支付");
		private String state;
		private String desc;

		private PayWay(String state, String desc) {
			this.state = state;
			this.desc = desc;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
	}

	/**
	 * 支付类别
	 * 
	 * @author chendehua
	 *
	 */
	public enum PayType {
		STAGEPAY("STAGEPAY", "分期支付"), BATCHPAY("BATCHPAY", "分批支付"), FULLPAY("FULLPAY", "一次性支付");

		private String state;
		private String desc;

		private PayType(String state, String desc) {
			this.state = state;
			this.desc = desc;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
	}

	/**
	 * 订单类别
	 * 
	 * @author chendehua
	 *
	 */
	public enum OrderType {
		HANSEL("HANSEL", "定金订单"), COUNSEL("COUNSEL", "咨询订单"), COMMON("COMMON", "普通订单");

		private String state;
		private String desc;

		private OrderType(String state, String desc) {
			this.state = state;
			this.desc = desc;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
	}

	/**
	 * 订单来源
	 * 
	 * @author chendehua
	 *
	 */
	public enum OrderFromType {
		ONLINE("ONLINE", "线上报名"), OFFLINE("OFFLINE", "(线下)分校报名");
		private String state;
		private String desc;

		private OrderFromType(String state, String desc) {
			this.state = state;
			this.desc = desc;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
	}

	/**
	 * 
	 * @author chendehua
	 *
	 */
	public enum OrderPayOperate {
		PAID("PAID", "付款"), REFUNDED("REFUNDED", "退款");
		private String state;
		private String desc;

		private OrderPayOperate(String state, String desc) {
			this.state = state;
			this.desc = desc;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
	}

	/**
	 * 扫码支付
	 * 
	 * @author chendehua
	 *
	 */
	public enum QrPayType {

		NATIVE(1l, "NATIVE"), SWEEPPAY(2l, "SWEEPPAY");
		private Long payId;
		private String transactionType;

		private QrPayType(Long payId, String transactionType) {
			this.payId = payId;
			this.transactionType = transactionType;
		}

		public Long getPayId() {
			return payId;
		}

		public void setPayId(Long payId) {
			this.payId = payId;
		}

		public String getTransactionType() {
			return transactionType;
		}

		public void setTransactionType(String transactionType) {
			this.transactionType = transactionType;
		}

	}

	/**
	 * 扫码支付:
	 * 
	 * @author chendehua
	 *
	 */
	public enum QrPayWay {

		SCAN("用户扫二维码图片", "SCAN"), MICRON("商家扫用户支付条码", "MICRON");
		private String way;
		private String value;

		private QrPayWay(String way, String value) {
			this.way = way;
			this.value = value;
		}

		public String getWay() {
			return way;
		}

		public void setWay(String way) {
			this.way = way;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

	/**
	 * 二维码支付回调结果
	 * 
	 * @author chendehua
	 *
	 */
	public enum QrPay {
		SUCCESS(200, "成功"), // 成功
		FAIL(400, "失败"), // 失败
		UNAUTHORIZED(401, "未认证,签名错误"), // 未认证（签名错误）
		NOT_FOUND(404, "接口不存在"), // 接口不存在
		INTERNAL_SERVER_ERROR(500, "服务器内部出错");// 服务器内部错误

		private QrPay(int code, String msg) {
			this.code = code;
			this.msg = msg;
		}

		public int code;
		public String msg;

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

	}
}
