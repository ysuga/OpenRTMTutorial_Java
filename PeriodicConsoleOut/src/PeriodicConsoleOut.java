// -*- Java -*-
/*!
 * @file PeriodicConsoleOut.java
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
 * @class PeriodicConsoleOut
 * @brief Periodically Console Out Component
 */
public class PeriodicConsoleOut implements RtcNewFunc, RtcDeleteFunc, RegisterModuleFunc {

//  Module specification
//  <rtc-template block="module_spec">
    public static String component_conf[] = {
    	    "implementation_id", "PeriodicConsoleOut",
    	    "type_name",         "PeriodicConsoleOut",
    	    "description",       "Periodically Console Out Component",
    	    "version",           "1.0.0",
    	    "vendor",            "ysuganet",
    	    "category",          "Example",
    	    "activity_type",     "STATIC",
    	    "max_instance",      "1",
    	    "language",          "Java",
    	    "lang_type",         "compile",
    	    ""
            };
//  </rtc-template>

    public RTObject_impl createRtc(Manager mgr) {
        return new PeriodicConsoleOutImpl(mgr);
    }

    public void deleteRtc(RTObject_impl rtcBase) {
        rtcBase = null;
    }
    public void registerModule() {
        Properties prop = new Properties(component_conf);
        final Manager manager = Manager.instance();
        manager.registerFactory(prop, new PeriodicConsoleOut(), new PeriodicConsoleOut());
    }
}
