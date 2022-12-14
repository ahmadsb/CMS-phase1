package sqlQuery;

import constants.DBConstants;
import constants.sqlQueries;

import model.db.Coupon;

public class CouponQuery extends GenQuery {
	static GenQuery _instance = null;

	public static GenQuery getInstance() {
		if (_instance == null) {
			_instance = new CouponQuery();
		}
		return _instance;

	}

	private CouponQuery() {
	}

	public String updateCoupon(Coupon coupon) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE ");
		sql.append(sqlQueries.nameDB);
		sql.append(".");
		sql.append(DBConstants.COUPONS);
		sql.append(" SET ");
		sql.append(DBConstants.COMPANY_ID);
		sql.append("=");
		sql.append(coupon.getCompanyID());
		sql.append(", ");

		sql.append(DBConstants.CATEGORY_ID);
		sql.append("=");
		sql.append(coupon.getCategoryID());
		sql.append(", ");

		sql.append(DBConstants.TITLE);
		sql.append("='");
		sql.append(coupon.getTitle());
		sql.append("', ");

		sql.append(DBConstants.DESCRIPTION);
		sql.append("='");
		sql.append(coupon.getDescription());
		sql.append("', ");

		sql.append(DBConstants.START_DATE);
		sql.append("='");
		sql.append(coupon.getStartDate());
		sql.append("', ");

		sql.append(DBConstants.END_DATE);
		sql.append("='");
		sql.append(coupon.getEndDate());
		sql.append("', ");

		sql.append(DBConstants.AMOUNT);
		sql.append("=");
		sql.append(coupon.getAmount());
		sql.append(", ");

		sql.append(DBConstants.PRICE);
		sql.append("=");
		sql.append(coupon.getPrice());
		sql.append(", ");

		sql.append(DBConstants.IMAGE);
		sql.append("='");
		sql.append(coupon.getImage());
		sql.append("' WHERE ");
		sql.append(DBConstants.ID);
		sql.append("=");
		sql.append(coupon.getId());
		sql.append(";");
		return sql.toString();
	}

	public String addCoupon(Coupon coupon) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ");
		sql.append(sqlQueries.nameDB);
		sql.append(".");
		sql.append(DBConstants.COUPONS);
		sql.append(" (");
		sql.append(DBConstants.COMPANY_ID);
		sql.append(", ");
		sql.append(DBConstants.CATEGORY_ID);
		sql.append(", ");
		sql.append(DBConstants.TITLE);
		sql.append(", ");
		sql.append(DBConstants.DESCRIPTION);
		sql.append(", ");
		sql.append(DBConstants.START_DATE);
		sql.append(", ");
		sql.append(DBConstants.END_DATE);
		sql.append(", ");
		sql.append(DBConstants.AMOUNT);
		sql.append(", ");
		sql.append(DBConstants.PRICE);
		sql.append(", ");
		sql.append(DBConstants.IMAGE);
		sql.append(") VALUES( ");

		sql.append(coupon.getCompanyID());
		sql.append(", ");
		sql.append(coupon.getCategoryID());
		sql.append(", '");
		sql.append(coupon.getTitle());
		sql.append("', '");
		sql.append(coupon.getDescription());
		sql.append("', '");
		sql.append(coupon.getStartDate());
		sql.append("', '");
		sql.append(coupon.getEndDate());
		sql.append("', ");
		sql.append(coupon.getAmount());
		sql.append(", ");
		sql.append(coupon.getPrice());
		sql.append(", '");
		sql.append(coupon.getImage());
		sql.append("');");

		return sql.toString();

	}

	public String deleteExpirationCoupon(String currDate) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE ");
		sql.append(sqlQueries.nameDB);
		sql.append(".");
		sql.append(DBConstants.COUPONS);
		sql.append(".*,");
		sql.append(sqlQueries.nameDB);
		sql.append(".");
		sql.append(DBConstants.CUSTOMERS_VS_COUPONS);
		sql.append(".* ");
		sql.append("FROM ");
		sql.append(sqlQueries.nameDB);
		sql.append(".");
		sql.append(DBConstants.COUPONS);
		sql.append(" inner join ");
		sql.append(sqlQueries.nameDB);
		sql.append(".");
		sql.append(DBConstants.CUSTOMERS_VS_COUPONS);
		sql.append(" WHERE ");
		sql.append(sqlQueries.nameDB);
		sql.append(".");
		sql.append(DBConstants.COUPONS);
		sql.append(".");
		sql.append(DBConstants.ID);
		sql.append("=");
		sql.append(sqlQueries.nameDB);
		sql.append(".");
		sql.append(DBConstants.CUSTOMERS_VS_COUPONS);
		sql.append(".");
		sql.append(DBConstants.COUPON_ID);
		sql.append(" AND '");
		sql.append(currDate);
		sql.append("' >= ");
		sql.append(sqlQueries.nameDB);
		sql.append(".");
		sql.append(DBConstants.COUPONS);
		sql.append(".");
		sql.append(DBConstants.END_DATE);
		sql.append(";");

		return sql.toString();

	}
}
