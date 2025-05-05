package com.example.stripepaymentimpl.services;

import org.springframework.stereotype.Service;


@Service
public class PaymentGatewaySelectorImpl implements PaymentGatewaySelector
{
    RazorpayGateway razorpayGateway;
    StripeGateway stripeGateway;

    public PaymentGatewaySelectorImpl(RazorpayGateway razorpayGateway,
                                      StripeGateway stripeGateway)
    {
        this.razorpayGateway = razorpayGateway;
        this.stripeGateway = stripeGateway;
    }

    @Override
    public PaymentGateway get()
    {
        // Some logic to select payment gateway dynamically
        // If test-transaction-stripe succeeds, select stripegateway as default gateway
        // Else if test-transaction-razorpay succeeds, select razorpay gateway as default

        return stripeGateway;
    }
}