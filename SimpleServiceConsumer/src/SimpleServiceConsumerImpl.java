// -*- Java -*-
/*!
 * @file  SimpleServiceConsumerImpl.java
 * @brief SimpleServiceConsumer
 * @date  $Date$
 *
 * $Id$
 */

import java.util.Random;

import jp.go.aist.rtm.RTC.DataFlowComponentBase;
import jp.go.aist.rtm.RTC.Manager;
import jp.go.aist.rtm.RTC.port.CorbaConsumer;
import jp.go.aist.rtm.RTC.port.CorbaPort;

import org.omg.CORBA.IntHolder;

import ysuga.SimpleService;
import RTC.ReturnCode_t;

/*!
 * @class SimpleServiceConsumerImpl
 * @brief SimpleServiceConsumer
 *
 */
public class SimpleServiceConsumerImpl extends DataFlowComponentBase {

	/*
	 * !
	 * 
	 * @brief constructor
	 * 
	 * @param manager Maneger Object
	 */
	public SimpleServiceConsumerImpl(Manager manager) {
		super(manager);
		// <rtc-template block="initializer">
		m_simpleServicePort = new CorbaPort("simpleService");
		// </rtc-template>

	}

	/**
	 * 
	 * The initialize action (on CREATED->ALIVE transition) formaer
	 * rtc_init_entry()
	 * 
	 * @return RTC::ReturnCode_t
	 * 
	 * 
	 */
	@Override
	protected ReturnCode_t onInitialize() {
		// Registration: InPort/OutPort/Service
		// <rtc-template block="registration">

		// Set service consumers to Ports
		m_simpleServicePort.registerConsumer("SimpleService",
				"ysuga.SimpleService", m_simpleServiceConsumerBase);

		// Set CORBA Service Ports
		addPort(m_simpleServicePort);
		// </rtc-template>
		return super.onInitialize();
	}

	/***
	 * 
	 * The finalize action (on ALIVE->END transition) formaer
	 * rtc_exiting_entry()
	 * 
	 * @return RTC::ReturnCode_t
	 * 
	 * 
	 */
	// @Override
	// protected ReturnCode_t onFinalize() {
	// return super.onFinalize();
	// }
	/***
	 * 
	 * The startup action when ExecutionContext startup former
	 * rtc_starting_entry()
	 * 
	 * @param ec_id
	 *            target ExecutionContext Id
	 * 
	 * @return RTC::ReturnCode_t
	 * 
	 * 
	 */
	// @Override
	// protected ReturnCode_t onStartup(int ec_id) {
	// return super.onStartup(ec_id);
	// }
	/***
	 * 
	 * The shutdown action when ExecutionContext stop former
	 * rtc_stopping_entry()
	 * 
	 * @param ec_id
	 *            target ExecutionContext Id
	 * 
	 * @return RTC::ReturnCode_t
	 * 
	 * 
	 */
	// @Override
	// protected ReturnCode_t onShutdown(int ec_id) {
	// return super.onShutdown(ec_id);
	// }
	/***
	 * 
	 * The activated action (Active state entry action) former
	 * rtc_active_entry()
	 * 
	 * @param ec_id
	 *            target ExecutionContext Id
	 * 
	 * @return RTC::ReturnCode_t
	 * 
	 * 
	 */
	// @Override
	// protected ReturnCode_t onActivated(int ec_id) {
	// return super.onActivated(ec_id);
	// }
	/***
	 * 
	 * The deactivated action (Active state exit action) former
	 * rtc_active_exit()
	 * 
	 * @param ec_id
	 *            target ExecutionContext Id
	 * 
	 * @return RTC::ReturnCode_t
	 * 
	 * 
	 */
	// @Override
	// protected ReturnCode_t onDeactivated(int ec_id) {
	// return super.onDeactivated(ec_id);
	// }
	/***
	 * 
	 * The execution action that is invoked periodically former rtc_active_do()
	 * 
	 * @param ec_id
	 *            target ExecutionContext Id
	 * 
	 * @return RTC::ReturnCode_t
	 * 
	 * 
	 */
	@Override
	protected ReturnCode_t onExecute(int ec_id) {
		System.out.println("Input Command: r:read, w:write, q:reset");
		try {
			int c = System.in.read();

			switch (c) {
			case 'r':
				IntHolder intHolder = new IntHolder();
				this.m_simpleServiceConsumerBase._ptr().read(intHolder);
				System.out.println("read(): data is " + intHolder.value);
				break;
			case 'w':
				int val = new Random().nextInt();
				this.m_simpleServiceConsumerBase._ptr().write(val);
				System.out.println("write(" + val + ")");
				break;
			case 'q':
				int ret = this.m_simpleServiceConsumerBase._ptr().reset();
				System.out.println("reset():returns " + ret);
				break;
			default:
				break;
			}
		} catch (Exception e) {
			System.out.println("Exception occurred:" + e);
		}
		return super.onExecute(ec_id);
	}

	/***
	 * 
	 * The aborting action when main logic error occurred. former
	 * rtc_aborting_entry()
	 * 
	 * @param ec_id
	 *            target ExecutionContext Id
	 * 
	 * @return RTC::ReturnCode_t
	 * 
	 * 
	 */
	// @Override
	// public ReturnCode_t onAborting(int ec_id) {
	// return super.onAborting(ec_id);
	// }
	/***
	 * 
	 * The error action in ERROR state former rtc_error_do()
	 * 
	 * @param ec_id
	 *            target ExecutionContext Id
	 * 
	 * @return RTC::ReturnCode_t
	 * 
	 * 
	 */
	// @Override
	// public ReturnCode_t onError(int ec_id) {
	// return super.onError(ec_id);
	// }
	/***
	 * 
	 * The reset action that is invoked resetting This is same but different the
	 * former rtc_init_entry()
	 * 
	 * @param ec_id
	 *            target ExecutionContext Id
	 * 
	 * @return RTC::ReturnCode_t
	 * 
	 * 
	 */
	// @Override
	// protected ReturnCode_t onReset(int ec_id) {
	// return super.onReset(ec_id);
	// }
	/***
	 * 
	 * The state update action that is invoked after onExecute() action no
	 * corresponding operation exists in OpenRTm-aist-0.2.0
	 * 
	 * @param ec_id
	 *            target ExecutionContext Id
	 * 
	 * @return RTC::ReturnCode_t
	 * 
	 * 
	 */
	// @Override
	// protected ReturnCode_t onStateUpdate(int ec_id) {
	// return super.onStateUpdate(ec_id);
	// }
	/***
	 * 
	 * The action that is invoked when execution context's rate is changed no
	 * corresponding operation exists in OpenRTm-aist-0.2.0
	 * 
	 * @param ec_id
	 *            target ExecutionContext Id
	 * 
	 * @return RTC::ReturnCode_t
	 * 
	 * 
	 */
	// @Override
	// protected ReturnCode_t onRateChanged(int ec_id) {
	// return super.onRateChanged(ec_id);
	// }
	//
	// DataInPort declaration
	// <rtc-template block="inport_declare">
	// </rtc-template>
	// DataOutPort declaration
	// <rtc-template block="outport_declare">
	// </rtc-template>
	// CORBA Port declaration
	// <rtc-template block="corbaport_declare">
	/*
	 * !
	 */
	protected CorbaPort m_simpleServicePort;

	// </rtc-template>

	// Service declaration
	// <rtc-template block="service_declare">

	// </rtc-template>

	// Consumer declaration
	// <rtc-template block="consumer_declare">
	protected CorbaConsumer<SimpleService> m_simpleServiceConsumerBase = new CorbaConsumer<SimpleService>(
			SimpleService.class);
	/*
	 * !
	 */
	protected SimpleService m_simpleServiceConsumer;

	// </rtc-template>

}
