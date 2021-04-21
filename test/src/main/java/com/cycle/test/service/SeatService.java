/**
 * 
 */
package com.cycle.test.service;

import com.cycle.test.dao.SeatDAO;
import com.cycle.test.model.Seat;

/**
 * @author
 *
 */
public class SeatService {

	private Long date = null;

	private Seat seat = null;

	private SeatDAO seatDAO = null;

	public SeatService(Long date, Seat seat) {
		this.date = date;
		this.seat = seat;
		seatDAO = new SeatDAO();
	}

	public double getPrice() {
		return seat.getPrice();
	}

	public void calculatePrice() {
		double price = seatDAO.getSeatPrice(seat.getType(), date);
		double totalPrice = price;
		seat.setPrice(totalPrice);
	}

}
