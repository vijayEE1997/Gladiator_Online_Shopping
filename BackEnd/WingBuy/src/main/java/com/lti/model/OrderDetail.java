/*package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_DETAIL_TBL")
public class OrderDetail {
@Id
@Column(name="OD_ID")
	private int odId;

//bi-directional many-to-one association to OrderTable
@OneToOne
@JoinColumn(name="O_ID")
private Order order;

//bi-directional many-to-one association to ProductTable
@ManyToOne
@JoinColumn(name="P_ID")
private Product product;
}
*/