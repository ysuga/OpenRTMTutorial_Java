// -*- Java -*-
/*!
 * @file ConfigurationTest.java
 * @date $Date$
 *
 * $Id$
 */

import jp.go.aist.rtm.RTC.Manager;
import jp.go.aist.rtm.RTC.RTObject_impl;
import jp.go.aist.rtm.RTC.RtcDeleteFunc;
import jp.go.aist.rtm.RTC.RtcNewFunc;
import jp.go.aist.rtm.RTC.RegisterModuleFunc;
import jp.go.aist.rtm.RTC.util.Properties;

/*!
 * @class ConfigurationTest
 * @brief Configuration Test
 */
public class ConfigurationTest implements RtcNewFunc, RtcDeleteFunc, RegisterModuleFunc {

//  Module specification
//  <rtc-template block="module_spec">
    public static String component_conf[] = {
    	    "implementation_id", "ConfigurationTest",
    	    "type_name",         "ConfigurationTest",
    	    "description",       "Configuration Test",
    	    "version",           "1.0.0",
    	    "vendor",            "ysugaet",
    	    "category",          "Example",
    	    "activity_type",     "STATIC",
    	    "max_instance",      "1",
    	    "language",          "Java",
    	    "lang_type",         "compile",
            // Configuration variables
            "conf.default.i_debug", "0",
            "conf.default.f_debug", "0.0",
            "conf.default.s_debug", "debug",
            // Widget
            "conf.__widget__.i_debug", "text",
            "conf.__widget__.f_debug", "text",
            "conf.__widget__.s_debug", "text",
            // Constraints
    	    ""
            };
//  </rtc-template>

    public RTObject_impl createRtc(Manager mgr) {
        return new ConfigurationTestImpl(mgr);
    }

    public void deleteRtc(RTObject_impl rtcBase) {
        rtcBase = null;
    }
    public void registerModule() {
        Properties prop = new Properties(component_conf);
        final Manager manager = Manager.instance();
        manager.registerFactory(prop, new ConfigurationTest(), new ConfigurationTest());
    }
}
