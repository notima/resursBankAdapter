package org.notima.businessobjects.adapter.resursbank;

import org.apache.karaf.util.tracker.BaseActivator;
import org.apache.karaf.util.tracker.annotation.ProvideService;
import org.apache.karaf.util.tracker.annotation.Services;
import org.notima.generic.ifacebusinessobjects.PaymentBatchFactory;
import org.notima.generic.ifacebusinessobjects.PaymentFactory;

@Services(
		provides = {
				@ProvideService(PaymentFactory.class),
				@ProvideService(PaymentBatchFactory.class)
		}
)
public class Activator extends BaseActivator {

}
