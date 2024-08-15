package com.example.ecommerce.LeaveRequest.exception;

public class LeaveRequestNotFoundException extends RuntimeException {
    public LeaveRequestNotFoundException() {
        super("Leave request not found");
    }
}
