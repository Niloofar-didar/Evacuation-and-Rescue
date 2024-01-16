package evacuation;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.Timer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import com.anylogic.engine.connectivity.ResultSet;
import com.anylogic.engine.connectivity.Statement;
import com.anylogic.engine.elements.*;
import com.anylogic.engine.markup.Network;
import com.anylogic.engine.Position;
import com.anylogic.engine.markup.PedFlowStatistics;
import com.anylogic.engine.markup.DensityMap;


import static java.lang.Math.*;
import static com.anylogic.engine.UtilitiesArray.*;
import static com.anylogic.engine.UtilitiesCollection.*;
import static com.anylogic.engine.presentation.UtilitiesColor.*;
import static com.anylogic.engine.HyperArray.*;

import com.anylogic.engine.*;
import com.anylogic.engine.analysis.*;
import com.anylogic.engine.connectivity.*;
import com.anylogic.engine.database.*;
import com.anylogic.engine.gis.*;
import com.anylogic.engine.markup.*;
import com.anylogic.engine.presentation.*;

import com.anylogic.libraries.pedestrian.*;
import com.anylogic.libraries.processmodeling.*;

import com.mysema.query.Tuple;
import com.mysema.query.sql.SQLBindings;
import static evacuation.DBDescriptor.*;

import java.awt.geom.Arc2D;

import javafx.util.converter.FloatStringConverter;
import net.pcal.sqlsheet.parser.InsertIntoStatement;
import java.sql.PreparedStatement;
import java.io.*;
import java.io.SerializablePermission;
import java.io.Serializable;
import com.anylogic.engine.markup.Ground;
//import com.anylogic.libraries.pedestrian.PedServices_xjal;
//import com.anylogic.libraries.pedestrian.PedGround_xjal; 

public class Main extends Agent
{
  /**
   * ChangeNumberOfAgents Dynamic Event Class
   */  
  public static class ChangeNumberOfAgents extends DynamicEvent {
    public int n;
  
    /**
     * Constructor<br>
     * Use <code>create_ChangeNumberOfAgents</code> method
     */
    public ChangeNumberOfAgents( Main _ao_xjal, double _dt_xjal , int n ) {
      this( _ao_xjal, _dt_xjal, false
		, n );
    }
    
    /**
     * Constructor<br>
     * Use <code>create_ChangeNumberOfAgents</code> method
     */
    public ChangeNumberOfAgents( Main _ao_xjal, double _dt_xjal, TimeUnits _units , int n ) {
      this( _ao_xjal, _dt_xjal, _units, false
		, n );
    }
  
    /**
     * Constructor<br>
     * Use <code>create_ChangeNumberOfAgents</code> method
     */
    public ChangeNumberOfAgents( Main _ao_xjal, double _t_xjal, boolean _absolute_xjal , int n ) {
      super( _ao_xjal, _t_xjal, _absolute_xjal );
      this.n = n;
    }
    
    /**
     * Constructor<br>
     * Use <code>create_ChangeNumberOfAgents</code> method
     */
    public ChangeNumberOfAgents( Main _ao_xjal, double _t_xjal, TimeUnits _units, boolean _absolute_xjal , int n ) {
      super( _ao_xjal, _t_xjal, _units, _absolute_xjal );
      this.n = n;
    }

    @AnyLogicInternalCodegenAPI
    public void execute() {
      super.execute(); // must be called!
      ((Main) getAgent()).on_ChangeNumberOfAgents_xjal( n );
    }
  }

  /**
   * Change Dynamic Event Class
   */  
  public static class Change extends DynamicEvent {
    public int n;
  
    /**
     * Constructor<br>
     * Use <code>create_Change</code> method
     */
    public Change( Main _ao_xjal, double _dt_xjal , int n ) {
      this( _ao_xjal, _dt_xjal, false
		, n );
    }
    
    /**
     * Constructor<br>
     * Use <code>create_Change</code> method
     */
    public Change( Main _ao_xjal, double _dt_xjal, TimeUnits _units , int n ) {
      this( _ao_xjal, _dt_xjal, _units, false
		, n );
    }
  
    /**
     * Constructor<br>
     * Use <code>create_Change</code> method
     */
    public Change( Main _ao_xjal, double _t_xjal, boolean _absolute_xjal , int n ) {
      super( _ao_xjal, _t_xjal, _absolute_xjal );
      this.n = n;
    }
    
    /**
     * Constructor<br>
     * Use <code>create_Change</code> method
     */
    public Change( Main _ao_xjal, double _t_xjal, TimeUnits _units, boolean _absolute_xjal , int n ) {
      super( _ao_xjal, _t_xjal, _units, _absolute_xjal );
      this.n = n;
    }

    @AnyLogicInternalCodegenAPI
    public void execute() {
      super.execute(); // must be called!
      ((Main) getAgent()).on_Change_xjal( n );
    }
  }

  // Excel Files
  public ExcelFile excel = new ExcelFile( Main.this, "/evacuation/", "results1.xlsx", false );
  public ExcelFile excel1 = new ExcelFile( Main.this, "/evacuation/", "Time results.xlsx", false );

  // Parameters

 
  public 
double  alarmTime;

  /**
   * Returns default value for parameter <code>alarmTime</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _alarmTime_DefaultValue_xjal() {
    final Main self = this;
    return 
540 
;
  }

  public void set_alarmTime( double alarmTime ) {
    if (alarmTime == this.alarmTime) {
      return;
    }
    double _oldValue_xjal = this.alarmTime;
    this.alarmTime = alarmTime;
    onChange_alarmTime_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter alarmTime.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_alarmTime()</code> method instead.
   */
  protected void onChange_alarmTime() {
    onChange_alarmTime_xjal( alarmTime );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_alarmTime_xjal( double oldValue ) {

 
;  
  }


 
  public 
double  visitorArrivalMultiplier;

  /**
   * Returns default value for parameter <code>visitorArrivalMultiplier</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _visitorArrivalMultiplier_DefaultValue_xjal() {
    final Main self = this;
    return 
2 
;
  }

  public void set_visitorArrivalMultiplier( double visitorArrivalMultiplier ) {
    if (visitorArrivalMultiplier == this.visitorArrivalMultiplier) {
      return;
    }
    double _oldValue_xjal = this.visitorArrivalMultiplier;
    this.visitorArrivalMultiplier = visitorArrivalMultiplier;
    onChange_visitorArrivalMultiplier_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter visitorArrivalMultiplier.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_visitorArrivalMultiplier()</code> method instead.
   */
  protected void onChange_visitorArrivalMultiplier() {
    onChange_visitorArrivalMultiplier_xjal( visitorArrivalMultiplier );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_visitorArrivalMultiplier_xjal( double oldValue ) {

 
;  
  }


 
  public 
boolean  addExit;

  /**
   * Returns default value for parameter <code>addExit</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _addExit_DefaultValue_xjal() {
    final Main self = this;
    return 
true 
;
  }

  public void set_addExit( boolean addExit ) {
    if (addExit == this.addExit) {
      return;
    }
    boolean _oldValue_xjal = this.addExit;
    this.addExit = addExit;
    onChange_addExit_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter addExit.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_addExit()</code> method instead.
   */
  protected void onChange_addExit() {
    onChange_addExit_xjal( addExit );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_addExit_xjal( boolean oldValue ) {

 
;
	int index;
    index = 0;
    for ( MyAgent self : myAgent ) {
      
      ArrayList<TargetLine> _value;
      _value = new ArrayList<TargetLine>(){{
	//if(addExit1)
	 add(enter);
	//else remove(enter);
	add(line30);
	//add(line20);
	//if (addExit)
	// add(line21);
	 //else remove(line30);
}}
;
      self.set_exits( _value );
      index++;
    }  
  }


 
  @AnyLogicCustomProposalType(AnyLogicCustomProposalType.Label.PER_HOUR)
  public 
double  workerArrivalRate;

  /**
   * Returns default value for parameter <code>workerArrivalRate</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _workerArrivalRate_DefaultValue_xjal() {
    final Main self = this;
    return 
40 
;
  }

  public double workerArrivalRate( RateUnits _units ) {
    return PER_HOUR.convertTo( workerArrivalRate, _units );
  }

  public void set_workerArrivalRate( double workerArrivalRate, RateUnits _units ) {
    set_workerArrivalRate( _units.convertTo( workerArrivalRate, PER_HOUR ) );
  }

  public void set_workerArrivalRate( double workerArrivalRate ) {
    if (workerArrivalRate == this.workerArrivalRate) {
      return;
    }
    double _oldValue_xjal = this.workerArrivalRate;
    this.workerArrivalRate = workerArrivalRate;
    onChange_workerArrivalRate_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter workerArrivalRate.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_workerArrivalRate()</code> method instead.
   */
  protected void onChange_workerArrivalRate() {
    onChange_workerArrivalRate_xjal( workerArrivalRate );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_workerArrivalRate_xjal( double oldValue ) {

 
;
	int index;
    {
      com.anylogic.libraries.pedestrian.PedSource<OfficeWorker> self = visitorSource1;
      double _value;
      _value = workerArrivalRate
;
      visitorSource1.set_rate( _value );
    }  
  }

  
  /**
   * Internal method. Returns the units used in design-time for setting the code of this parameter (these units may be e.g. used for adaptation of dynamic parameter arguments)
   */
  @AnyLogicInternalCodegenAPI
  public RateUnits getUnitsForCodeOf_workerArrivalRate() {
    return PER_HOUR;
  }
  
  /**
   * Internal method. Returns the units of this parameter.
   */
  @AnyLogicInternalCodegenAPI
  public RateUnits getUnitsOf_workerArrivalRate() {
    return PER_HOUR;
  }

 
  public 
boolean  addExit1;

  /**
   * Returns default value for parameter <code>addExit1</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _addExit1_DefaultValue_xjal() {
    final Main self = this;
    return 
true 
;
  }

  public void set_addExit1( boolean addExit1 ) {
    if (addExit1 == this.addExit1) {
      return;
    }
    boolean _oldValue_xjal = this.addExit1;
    this.addExit1 = addExit1;
    onChange_addExit1_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter addExit1.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_addExit1()</code> method instead.
   */
  protected void onChange_addExit1() {
    onChange_addExit1_xjal( addExit1 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_addExit1_xjal( boolean oldValue ) {

 
;
	int index;
    {
      Evacuation self = evacuation;
      ArrayList<TargetLine> _value;
      _value = new ArrayList<TargetLine>(){{
	//if(addExit1)
	//if(enter.getColor()!=red)
	 add(enter);
	//else remove(enter);
	
	
	 add(line30);
	// else remove(line30);
}}
;
      evacuation.set_exits( _value );
    }
    index = 0;
    for ( MyAgent self : myAgent ) {
      
      ArrayList<TargetLine> _value;
      _value = new ArrayList<TargetLine>(){{
	//if(addExit1)
	 add(enter);
	//else remove(enter);
	add(line30);
	//add(line20);
	//if (addExit)
	// add(line21);
	 //else remove(line30);
}}
;
      self.set_exits( _value );
      index++;
    }
    index = 0;
    for ( MyAgent self : myAgent ) {
      
      ArrayList<TargetLine> _value;
      _value = new ArrayList<TargetLine>(){{
	//if(addExit1)
	// add(enter);
	//add(line30);
	add(line20);
	add(line21);
	 
}}
;
      self.set_allexits( _value );
      index++;
    }  
  }


 
  public 
boolean  active_dynamic;

  /**
   * Returns default value for parameter <code>active_dynamic</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _active_dynamic_DefaultValue_xjal() {
    final Main self = this;
    return 
false 
;
  }

  public void set_active_dynamic( boolean active_dynamic ) {
    if (active_dynamic == this.active_dynamic) {
      return;
    }
    boolean _oldValue_xjal = this.active_dynamic;
    this.active_dynamic = active_dynamic;
    onChange_active_dynamic_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter active_dynamic.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_active_dynamic()</code> method instead.
   */
  protected void onChange_active_dynamic() {
    onChange_active_dynamic_xjal( active_dynamic );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_active_dynamic_xjal( boolean oldValue ) {

 
;  
  }


 
  public 
TargetLine  safe_exit;

  /**
   * Returns default value for parameter <code>safe_exit</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public TargetLine _safe_exit_DefaultValue_xjal() {
    final Main self = this;
    return 
 
;
  }

  public void set_safe_exit( TargetLine safe_exit ) {
    if (safe_exit == this.safe_exit) {
      return;
    }
    TargetLine _oldValue_xjal = this.safe_exit;
    this.safe_exit = safe_exit;
    onChange_safe_exit_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter safe_exit.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_safe_exit()</code> method instead.
   */
  protected void onChange_safe_exit() {
    onChange_safe_exit_xjal( safe_exit );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_safe_exit_xjal( TargetLine oldValue ) {

 
;  
  }


 
  @AnyLogicCustomProposalType(AnyLogicCustomProposalType.Label.PER_MINUTE)
  public 
double  newvisitorArrivalRate;

  /**
   * Returns default value for parameter <code>newvisitorArrivalRate</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _newvisitorArrivalRate_DefaultValue_xjal() {
    final Main self = this;
    return 
6 
;
  }

  public double newvisitorArrivalRate( RateUnits _units ) {
    return PER_MINUTE.convertTo( newvisitorArrivalRate, _units );
  }

  public void set_newvisitorArrivalRate( double newvisitorArrivalRate, RateUnits _units ) {
    set_newvisitorArrivalRate( _units.convertTo( newvisitorArrivalRate, PER_MINUTE ) );
  }

  public void set_newvisitorArrivalRate( double newvisitorArrivalRate ) {
    if (newvisitorArrivalRate == this.newvisitorArrivalRate) {
      return;
    }
    double _oldValue_xjal = this.newvisitorArrivalRate;
    this.newvisitorArrivalRate = newvisitorArrivalRate;
    onChange_newvisitorArrivalRate_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter newvisitorArrivalRate.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_newvisitorArrivalRate()</code> method instead.
   */
  protected void onChange_newvisitorArrivalRate() {
    onChange_newvisitorArrivalRate_xjal( newvisitorArrivalRate );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_newvisitorArrivalRate_xjal( double oldValue ) {

 
;  
  }

  
  /**
   * Internal method. Returns the units used in design-time for setting the code of this parameter (these units may be e.g. used for adaptation of dynamic parameter arguments)
   */
  @AnyLogicInternalCodegenAPI
  public RateUnits getUnitsForCodeOf_newvisitorArrivalRate() {
    return PER_MINUTE;
  }
  
  /**
   * Internal method. Returns the units of this parameter.
   */
  @AnyLogicInternalCodegenAPI
  public RateUnits getUnitsOf_newvisitorArrivalRate() {
    return PER_MINUTE;
  }

 
  public 
boolean  active_predict_help;

  /**
   * Returns default value for parameter <code>active_predict_help</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _active_predict_help_DefaultValue_xjal() {
    final Main self = this;
    return 
false 
;
  }

  public void set_active_predict_help( boolean active_predict_help ) {
    if (active_predict_help == this.active_predict_help) {
      return;
    }
    boolean _oldValue_xjal = this.active_predict_help;
    this.active_predict_help = active_predict_help;
    onChange_active_predict_help_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter active_predict_help.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_active_predict_help()</code> method instead.
   */
  protected void onChange_active_predict_help() {
    onChange_active_predict_help_xjal( active_predict_help );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_active_predict_help_xjal( boolean oldValue ) {

 
;  
  }


  /**
   * for myagent
   */
 
  public 
MyAgent  fire_center;

  /**
   * Returns default value for parameter <code>fire_center</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public MyAgent _fire_center_DefaultValue_xjal() {
    final Main self = this;
    return 
 
;
  }

  public void set_fire_center( MyAgent fire_center ) {
    if (fire_center == this.fire_center) {
      return;
    }
    MyAgent _oldValue_xjal = this.fire_center;
    this.fire_center = fire_center;
    onChange_fire_center_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter fire_center.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_fire_center()</code> method instead.
   */
  protected void onChange_fire_center() {
    onChange_fire_center_xjal( fire_center );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_fire_center_xjal( MyAgent oldValue ) {

 
;  
  }


  /**
   * //sorted list of sensors with order near to center of fire<br>
   * for myagent
   */
 
  public 
double[]  dis_from_fire;

  /**
   * Returns default value for parameter <code>dis_from_fire</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double[] _dis_from_fire_DefaultValue_xjal() {
    final Main self = this;
    return 
new double [218]//doors + sensors 
;
  }

  public void set_dis_from_fire( double[] dis_from_fire ) {
    if (dis_from_fire == this.dis_from_fire) {
      return;
    }
    double[] _oldValue_xjal = this.dis_from_fire;
    this.dis_from_fire = dis_from_fire;
    onChange_dis_from_fire_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter dis_from_fire.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_dis_from_fire()</code> method instead.
   */
  protected void onChange_dis_from_fire() {
    onChange_dis_from_fire_xjal( dis_from_fire );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_dis_from_fire_xjal( double[] oldValue ) {

 
;  
  }


  /**
   * light : 2-5 chain/1h =>4ch=/60min =1.3mper min = 0.022m.s
   */
 
  @AnyLogicCustomProposalType(AnyLogicCustomProposalType.Label.MPS)
  public 
double  fire_speed;

  /**
   * Returns default value for parameter <code>fire_speed</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _fire_speed_DefaultValue_xjal() {
    final Main self = this;
    return 
0.026
//22 first 
;
  }

  public double fire_speed( SpeedUnits _units ) {
    return MPS.convertTo( fire_speed, _units );
  }

  public void set_fire_speed( double fire_speed, SpeedUnits _units ) {
    set_fire_speed( _units.convertTo( fire_speed, MPS ) );
  }

  public void set_fire_speed( double fire_speed ) {
    if (fire_speed == this.fire_speed) {
      return;
    }
    double _oldValue_xjal = this.fire_speed;
    this.fire_speed = fire_speed;
    onChange_fire_speed_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter fire_speed.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_fire_speed()</code> method instead.
   */
  protected void onChange_fire_speed() {
    onChange_fire_speed_xjal( fire_speed );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_fire_speed_xjal( double oldValue ) {

 
;  
  }

  
  /**
   * Internal method. Returns the units used in design-time for setting the code of this parameter (these units may be e.g. used for adaptation of dynamic parameter arguments)
   */
  @AnyLogicInternalCodegenAPI
  public SpeedUnits getUnitsForCodeOf_fire_speed() {
    return MPS;
  }
  
  /**
   * Internal method. Returns the units of this parameter.
   */
  @AnyLogicInternalCodegenAPI
  public SpeedUnits getUnitsOf_fire_speed() {
    return MPS;
  }

  /**
   * the time passed from firing
   */
 
  public 
double  now_time;

  /**
   * Returns default value for parameter <code>now_time</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _now_time_DefaultValue_xjal() {
    final Main self = this;
    return 
0 
;
  }

  public void set_now_time( double now_time ) {
    if (now_time == this.now_time) {
      return;
    }
    double _oldValue_xjal = this.now_time;
    this.now_time = now_time;
    onChange_now_time_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter now_time.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_now_time()</code> method instead.
   */
  protected void onChange_now_time() {
    onChange_now_time_xjal( now_time );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_now_time_xjal( double oldValue ) {

 
;  
  }


 
  public 
boolean  dynamic_help;

  /**
   * Returns default value for parameter <code>dynamic_help</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _dynamic_help_DefaultValue_xjal() {
    final Main self = this;
    return 
false 
;
  }

  public void set_dynamic_help( boolean dynamic_help ) {
    if (dynamic_help == this.dynamic_help) {
      return;
    }
    boolean _oldValue_xjal = this.dynamic_help;
    this.dynamic_help = dynamic_help;
    onChange_dynamic_help_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter dynamic_help.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_dynamic_help()</code> method instead.
   */
  protected void onChange_dynamic_help() {
    onChange_dynamic_help_xjal( dynamic_help );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_dynamic_help_xjal( boolean oldValue ) {

 
;  
  }


  /**
   * //list of sensors that are in red state 
   */
 
  public 
MyAgent[]  connectedag2;

  /**
   * Returns default value for parameter <code>connectedag2</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public MyAgent[] _connectedag2_DefaultValue_xjal() {
    final Main self = this;
    return 
new MyAgent [218]//doors + sensors 
;
  }

  public void set_connectedag2( MyAgent[] connectedag2 ) {
    if (connectedag2 == this.connectedag2) {
      return;
    }
    MyAgent[] _oldValue_xjal = this.connectedag2;
    this.connectedag2 = connectedag2;
    onChange_connectedag2_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter connectedag2.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_connectedag2()</code> method instead.
   */
  protected void onChange_connectedag2() {
    onChange_connectedag2_xjal( connectedag2 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_connectedag2_xjal( MyAgent[] oldValue ) {

 
;  
  }


 
  public 
boolean  active_safest;

  /**
   * Returns default value for parameter <code>active_safest</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _active_safest_DefaultValue_xjal() {
    final Main self = this;
    return 
false 
;
  }

  public void set_active_safest( boolean active_safest ) {
    if (active_safest == this.active_safest) {
      return;
    }
    boolean _oldValue_xjal = this.active_safest;
    this.active_safest = active_safest;
    onChange_active_safest_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter active_safest.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_active_safest()</code> method instead.
   */
  protected void onChange_active_safest() {
    onChange_active_safest_xjal( active_safest );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_active_safest_xjal( boolean oldValue ) {

 
;  
  }


 
  public 
boolean  static_withdoor_sensor;

  /**
   * Returns default value for parameter <code>static_withdoor_sensor</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _static_withdoor_sensor_DefaultValue_xjal() {
    final Main self = this;
    return 
false 
;
  }

  public void set_static_withdoor_sensor( boolean static_withdoor_sensor ) {
    if (static_withdoor_sensor == this.static_withdoor_sensor) {
      return;
    }
    boolean _oldValue_xjal = this.static_withdoor_sensor;
    this.static_withdoor_sensor = static_withdoor_sensor;
    onChange_static_withdoor_sensor_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter static_withdoor_sensor.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_static_withdoor_sensor()</code> method instead.
   */
  protected void onChange_static_withdoor_sensor() {
    onChange_static_withdoor_sensor_xjal( static_withdoor_sensor );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_static_withdoor_sensor_xjal( boolean oldValue ) {

 
;  
  }


  /**
   * //sorted list of sensors with order near to center of fire<br>
   * for myagent
   */
 
  public 
boolean  explosion;

  /**
   * Returns default value for parameter <code>explosion</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _explosion_DefaultValue_xjal() {
    final Main self = this;
    return 
false//to run fire alarm 1 time 
;
  }

  public void set_explosion( boolean explosion ) {
    if (explosion == this.explosion) {
      return;
    }
    boolean _oldValue_xjal = this.explosion;
    this.explosion = explosion;
    onChange_explosion_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter explosion.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_explosion()</code> method instead.
   */
  protected void onChange_explosion() {
    onChange_explosion_xjal( explosion );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_explosion_xjal( boolean oldValue ) {

 
;  
  }


  /**
   * //sorted list of sensors with order near to center of fire
   */
 
  public 
MyAgent[]  floor1_agents;

  /**
   * Returns default value for parameter <code>floor1_agents</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public MyAgent[] _floor1_agents_DefaultValue_xjal() {
    final Main self = this;
    return 
new MyAgent [200]//doors + sensors 
;
  }

  public void set_floor1_agents( MyAgent[] floor1_agents ) {
    if (floor1_agents == this.floor1_agents) {
      return;
    }
    MyAgent[] _oldValue_xjal = this.floor1_agents;
    this.floor1_agents = floor1_agents;
    onChange_floor1_agents_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter floor1_agents.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_floor1_agents()</code> method instead.
   */
  protected void onChange_floor1_agents() {
    onChange_floor1_agents_xjal( floor1_agents );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_floor1_agents_xjal( MyAgent[] oldValue ) {

 
;  
  }


  /**
   * //sorted list of sensors with order near to center of fire
   */
 
  public 
MyAgent[]  floor2_agents;

  /**
   * Returns default value for parameter <code>floor2_agents</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public MyAgent[] _floor2_agents_DefaultValue_xjal() {
    final Main self = this;
    return 
new MyAgent [200]//doors + sensors 
;
  }

  public void set_floor2_agents( MyAgent[] floor2_agents ) {
    if (floor2_agents == this.floor2_agents) {
      return;
    }
    MyAgent[] _oldValue_xjal = this.floor2_agents;
    this.floor2_agents = floor2_agents;
    onChange_floor2_agents_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter floor2_agents.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_floor2_agents()</code> method instead.
   */
  protected void onChange_floor2_agents() {
    onChange_floor2_agents_xjal( floor2_agents );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_floor2_agents_xjal( MyAgent[] oldValue ) {

 
;  
  }


  /**
   * for myagent
   */
 
  public 
boolean  a1;

  /**
   * Returns default value for parameter <code>a1</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _a1_DefaultValue_xjal() {
    final Main self = this;
    return 
false 
;
  }

  public void set_a1( boolean a1 ) {
    if (a1 == this.a1) {
      return;
    }
    boolean _oldValue_xjal = this.a1;
    this.a1 = a1;
    onChange_a1_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter a1.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_a1()</code> method instead.
   */
  protected void onChange_a1() {
    onChange_a1_xjal( a1 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_a1_xjal( boolean oldValue ) {

 
;  
  }


  /**
   * for myagent
   */
 
  public 
boolean  a2;

  /**
   * Returns default value for parameter <code>a2</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _a2_DefaultValue_xjal() {
    final Main self = this;
    return 
false 
;
  }

  public void set_a2( boolean a2 ) {
    if (a2 == this.a2) {
      return;
    }
    boolean _oldValue_xjal = this.a2;
    this.a2 = a2;
    onChange_a2_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter a2.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_a2()</code> method instead.
   */
  protected void onChange_a2() {
    onChange_a2_xjal( a2 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_a2_xjal( boolean oldValue ) {

 
;  
  }


  /**
   * for myagent
   */
 
  public 
boolean  a3;

  /**
   * Returns default value for parameter <code>a3</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _a3_DefaultValue_xjal() {
    final Main self = this;
    return 
false 
;
  }

  public void set_a3( boolean a3 ) {
    if (a3 == this.a3) {
      return;
    }
    boolean _oldValue_xjal = this.a3;
    this.a3 = a3;
    onChange_a3_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter a3.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_a3()</code> method instead.
   */
  protected void onChange_a3() {
    onChange_a3_xjal( a3 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_a3_xjal( boolean oldValue ) {

 
;  
  }


  /**
   * areaaas //only one time when fires we alert people
   */
 
  public 
boolean  a4;

  /**
   * Returns default value for parameter <code>a4</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _a4_DefaultValue_xjal() {
    final Main self = this;
    return 
false 
;
  }

  public void set_a4( boolean a4 ) {
    if (a4 == this.a4) {
      return;
    }
    boolean _oldValue_xjal = this.a4;
    this.a4 = a4;
    onChange_a4_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter a4.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_a4()</code> method instead.
   */
  protected void onChange_a4() {
    onChange_a4_xjal( a4 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_a4_xjal( boolean oldValue ) {

 
;  
  }


  /**
   * for myagent
   */
 
  public 
int  coffee_counter;

  /**
   * Returns default value for parameter <code>coffee_counter</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _coffee_counter_DefaultValue_xjal() {
    final Main self = this;
    return 
0 
;
  }

  public void set_coffee_counter( int coffee_counter ) {
    if (coffee_counter == this.coffee_counter) {
      return;
    }
    int _oldValue_xjal = this.coffee_counter;
    this.coffee_counter = coffee_counter;
    onChange_coffee_counter_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter coffee_counter.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_coffee_counter()</code> method instead.
   */
  protected void onChange_coffee_counter() {
    onChange_coffee_counter_xjal( coffee_counter );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_coffee_counter_xjal( int oldValue ) {

 
;  
  }


  /**
   * for myagent
   */
 
  public 
long  total_beforealarm;

  /**
   * Returns default value for parameter <code>total_beforealarm</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public long _total_beforealarm_DefaultValue_xjal() {
    final Main self = this;
    return 
1 
;
  }

  public void set_total_beforealarm( long total_beforealarm ) {
    if (total_beforealarm == this.total_beforealarm) {
      return;
    }
    long _oldValue_xjal = this.total_beforealarm;
    this.total_beforealarm = total_beforealarm;
    onChange_total_beforealarm_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter total_beforealarm.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_total_beforealarm()</code> method instead.
   */
  protected void onChange_total_beforealarm() {
    onChange_total_beforealarm_xjal( total_beforealarm );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_total_beforealarm_xjal( long oldValue ) {

 
;  
  }


  /**
   * for myagent
   */
 
  public 
boolean  as1;

  /**
   * Returns default value for parameter <code>as1</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _as1_DefaultValue_xjal() {
    final Main self = this;
    return 
false 
;
  }

  public void set_as1( boolean as1 ) {
    if (as1 == this.as1) {
      return;
    }
    boolean _oldValue_xjal = this.as1;
    this.as1 = as1;
    onChange_as1_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter as1.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_as1()</code> method instead.
   */
  protected void onChange_as1() {
    onChange_as1_xjal( as1 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_as1_xjal( boolean oldValue ) {

 
;  
  }


  /**
   * for myagent
   */
 
  public 
boolean  as3_2;

  /**
   * Returns default value for parameter <code>as3_2</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _as3_2_DefaultValue_xjal() {
    final Main self = this;
    return 
false 
;
  }

  public void set_as3_2( boolean as3_2 ) {
    if (as3_2 == this.as3_2) {
      return;
    }
    boolean _oldValue_xjal = this.as3_2;
    this.as3_2 = as3_2;
    onChange_as3_2_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter as3_2.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_as3_2()</code> method instead.
   */
  protected void onChange_as3_2() {
    onChange_as3_2_xjal( as3_2 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_as3_2_xjal( boolean oldValue ) {

 
;  
  }


  /**
   * for myagent
   */
 
  public 
boolean  a3_4;

  /**
   * Returns default value for parameter <code>a3_4</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _a3_4_DefaultValue_xjal() {
    final Main self = this;
    return 
false 
;
  }

  public void set_a3_4( boolean a3_4 ) {
    if (a3_4 == this.a3_4) {
      return;
    }
    boolean _oldValue_xjal = this.a3_4;
    this.a3_4 = a3_4;
    onChange_a3_4_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter a3_4.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_a3_4()</code> method instead.
   */
  protected void onChange_a3_4() {
    onChange_a3_4_xjal( a3_4 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_a3_4_xjal( boolean oldValue ) {

 
;  
  }


  /**
   * for myagent
   */
 
  public 
boolean  a1_1;

  /**
   * Returns default value for parameter <code>a1_1</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _a1_1_DefaultValue_xjal() {
    final Main self = this;
    return 
false 
;
  }

  public void set_a1_1( boolean a1_1 ) {
    if (a1_1 == this.a1_1) {
      return;
    }
    boolean _oldValue_xjal = this.a1_1;
    this.a1_1 = a1_1;
    onChange_a1_1_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter a1_1.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_a1_1()</code> method instead.
   */
  protected void onChange_a1_1() {
    onChange_a1_1_xjal( a1_1 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_a1_1_xjal( boolean oldValue ) {

 
;  
  }


  /**
   * for myagent
   */
 
  public 
boolean  a3_2;

  /**
   * Returns default value for parameter <code>a3_2</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _a3_2_DefaultValue_xjal() {
    final Main self = this;
    return 
false 
;
  }

  public void set_a3_2( boolean a3_2 ) {
    if (a3_2 == this.a3_2) {
      return;
    }
    boolean _oldValue_xjal = this.a3_2;
    this.a3_2 = a3_2;
    onChange_a3_2_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter a3_2.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_a3_2()</code> method instead.
   */
  protected void onChange_a3_2() {
    onChange_a3_2_xjal( a3_2 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_a3_2_xjal( boolean oldValue ) {

 
;  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    alarmTime = _alarmTime_DefaultValue_xjal();
    visitorArrivalMultiplier = _visitorArrivalMultiplier_DefaultValue_xjal();
    addExit = _addExit_DefaultValue_xjal();
    workerArrivalRate = _workerArrivalRate_DefaultValue_xjal();
    addExit1 = _addExit1_DefaultValue_xjal();
    active_dynamic = _active_dynamic_DefaultValue_xjal();
    safe_exit = _safe_exit_DefaultValue_xjal();
    newvisitorArrivalRate = _newvisitorArrivalRate_DefaultValue_xjal();
    active_predict_help = _active_predict_help_DefaultValue_xjal();
    fire_center = _fire_center_DefaultValue_xjal();
    dis_from_fire = _dis_from_fire_DefaultValue_xjal();
    fire_speed = _fire_speed_DefaultValue_xjal();
    now_time = _now_time_DefaultValue_xjal();
    dynamic_help = _dynamic_help_DefaultValue_xjal();
    connectedag2 = _connectedag2_DefaultValue_xjal();
    active_safest = _active_safest_DefaultValue_xjal();
    static_withdoor_sensor = _static_withdoor_sensor_DefaultValue_xjal();
    explosion = _explosion_DefaultValue_xjal();
    floor1_agents = _floor1_agents_DefaultValue_xjal();
    floor2_agents = _floor2_agents_DefaultValue_xjal();
    a1 = _a1_DefaultValue_xjal();
    a2 = _a2_DefaultValue_xjal();
    a3 = _a3_DefaultValue_xjal();
    a4 = _a4_DefaultValue_xjal();
    coffee_counter = _coffee_counter_DefaultValue_xjal();
    total_beforealarm = _total_beforealarm_DefaultValue_xjal();
    as1 = _as1_DefaultValue_xjal();
    as3_2 = _as3_2_DefaultValue_xjal();
    a3_4 = _a3_4_DefaultValue_xjal();
    a1_1 = _a1_1_DefaultValue_xjal();
    a3_2 = _a3_2_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "alarmTime":
      if ( _callOnChange_xjal ) {
        set_alarmTime( ((Number) _value_xjal).doubleValue() );
      } else {
        alarmTime = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "visitorArrivalMultiplier":
      if ( _callOnChange_xjal ) {
        set_visitorArrivalMultiplier( ((Number) _value_xjal).doubleValue() );
      } else {
        visitorArrivalMultiplier = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "addExit":
      if ( _callOnChange_xjal ) {
        set_addExit( (Boolean) _value_xjal );
      } else {
        addExit = (Boolean) _value_xjal;
      }
      return true;
    case "workerArrivalRate":
      if ( _callOnChange_xjal ) {
        set_workerArrivalRate( ((Number) _value_xjal).doubleValue() );
      } else {
        workerArrivalRate = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "addExit1":
      if ( _callOnChange_xjal ) {
        set_addExit1( (Boolean) _value_xjal );
      } else {
        addExit1 = (Boolean) _value_xjal;
      }
      return true;
    case "active_dynamic":
      if ( _callOnChange_xjal ) {
        set_active_dynamic( (Boolean) _value_xjal );
      } else {
        active_dynamic = (Boolean) _value_xjal;
      }
      return true;
    case "safe_exit":
      if ( _callOnChange_xjal ) {
        set_safe_exit( (TargetLine) _value_xjal );
      } else {
        safe_exit = (TargetLine) _value_xjal;
      }
      return true;
    case "newvisitorArrivalRate":
      if ( _callOnChange_xjal ) {
        set_newvisitorArrivalRate( ((Number) _value_xjal).doubleValue() );
      } else {
        newvisitorArrivalRate = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "active_predict_help":
      if ( _callOnChange_xjal ) {
        set_active_predict_help( (Boolean) _value_xjal );
      } else {
        active_predict_help = (Boolean) _value_xjal;
      }
      return true;
    case "fire_center":
      if ( _callOnChange_xjal ) {
        set_fire_center( (MyAgent) _value_xjal );
      } else {
        fire_center = (MyAgent) _value_xjal;
      }
      return true;
    case "dis_from_fire":
      if ( _callOnChange_xjal ) {
        set_dis_from_fire( (double[]) _value_xjal );
      } else {
        dis_from_fire = (double[]) _value_xjal;
      }
      return true;
    case "fire_speed":
      if ( _callOnChange_xjal ) {
        set_fire_speed( ((Number) _value_xjal).doubleValue() );
      } else {
        fire_speed = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "now_time":
      if ( _callOnChange_xjal ) {
        set_now_time( ((Number) _value_xjal).doubleValue() );
      } else {
        now_time = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "dynamic_help":
      if ( _callOnChange_xjal ) {
        set_dynamic_help( (Boolean) _value_xjal );
      } else {
        dynamic_help = (Boolean) _value_xjal;
      }
      return true;
    case "connectedag2":
      if ( _callOnChange_xjal ) {
        set_connectedag2( (MyAgent[]) _value_xjal );
      } else {
        connectedag2 = (MyAgent[]) _value_xjal;
      }
      return true;
    case "active_safest":
      if ( _callOnChange_xjal ) {
        set_active_safest( (Boolean) _value_xjal );
      } else {
        active_safest = (Boolean) _value_xjal;
      }
      return true;
    case "static_withdoor_sensor":
      if ( _callOnChange_xjal ) {
        set_static_withdoor_sensor( (Boolean) _value_xjal );
      } else {
        static_withdoor_sensor = (Boolean) _value_xjal;
      }
      return true;
    case "explosion":
      if ( _callOnChange_xjal ) {
        set_explosion( (Boolean) _value_xjal );
      } else {
        explosion = (Boolean) _value_xjal;
      }
      return true;
    case "floor1_agents":
      if ( _callOnChange_xjal ) {
        set_floor1_agents( (MyAgent[]) _value_xjal );
      } else {
        floor1_agents = (MyAgent[]) _value_xjal;
      }
      return true;
    case "floor2_agents":
      if ( _callOnChange_xjal ) {
        set_floor2_agents( (MyAgent[]) _value_xjal );
      } else {
        floor2_agents = (MyAgent[]) _value_xjal;
      }
      return true;
    case "a1":
      if ( _callOnChange_xjal ) {
        set_a1( (Boolean) _value_xjal );
      } else {
        a1 = (Boolean) _value_xjal;
      }
      return true;
    case "a2":
      if ( _callOnChange_xjal ) {
        set_a2( (Boolean) _value_xjal );
      } else {
        a2 = (Boolean) _value_xjal;
      }
      return true;
    case "a3":
      if ( _callOnChange_xjal ) {
        set_a3( (Boolean) _value_xjal );
      } else {
        a3 = (Boolean) _value_xjal;
      }
      return true;
    case "a4":
      if ( _callOnChange_xjal ) {
        set_a4( (Boolean) _value_xjal );
      } else {
        a4 = (Boolean) _value_xjal;
      }
      return true;
    case "coffee_counter":
      if ( _callOnChange_xjal ) {
        set_coffee_counter( ((Number) _value_xjal).intValue() );
      } else {
        coffee_counter = ((Number) _value_xjal).intValue();
      }
      return true;
    case "total_beforealarm":
      if ( _callOnChange_xjal ) {
        set_total_beforealarm( ((Number) _value_xjal).longValue() );
      } else {
        total_beforealarm = ((Number) _value_xjal).longValue();
      }
      return true;
    case "as1":
      if ( _callOnChange_xjal ) {
        set_as1( (Boolean) _value_xjal );
      } else {
        as1 = (Boolean) _value_xjal;
      }
      return true;
    case "as3_2":
      if ( _callOnChange_xjal ) {
        set_as3_2( (Boolean) _value_xjal );
      } else {
        as3_2 = (Boolean) _value_xjal;
      }
      return true;
    case "a3_4":
      if ( _callOnChange_xjal ) {
        set_a3_4( (Boolean) _value_xjal );
      } else {
        a3_4 = (Boolean) _value_xjal;
      }
      return true;
    case "a1_1":
      if ( _callOnChange_xjal ) {
        set_a1_1( (Boolean) _value_xjal );
      } else {
        a1_1 = (Boolean) _value_xjal;
      }
      return true;
    case "a3_2":
      if ( _callOnChange_xjal ) {
        set_a3_2( (Boolean) _value_xjal );
      } else {
        a3_2 = (Boolean) _value_xjal;
      }
      return true;
    default:
      return super.setParameter( _name_xjal, _value_xjal, _callOnChange_xjal );
    }
  }

  @Override
  public <T> T getParameter(String _name_xjal) {
    Object _result_xjal;
    switch ( _name_xjal ) {
    case "alarmTime": _result_xjal = alarmTime; break;
    case "visitorArrivalMultiplier": _result_xjal = visitorArrivalMultiplier; break;
    case "addExit": _result_xjal = addExit; break;
    case "workerArrivalRate": _result_xjal = workerArrivalRate; break;
    case "addExit1": _result_xjal = addExit1; break;
    case "active_dynamic": _result_xjal = active_dynamic; break;
    case "safe_exit": _result_xjal = safe_exit; break;
    case "newvisitorArrivalRate": _result_xjal = newvisitorArrivalRate; break;
    case "active_predict_help": _result_xjal = active_predict_help; break;
    case "fire_center": _result_xjal = fire_center; break;
    case "dis_from_fire": _result_xjal = dis_from_fire; break;
    case "fire_speed": _result_xjal = fire_speed; break;
    case "now_time": _result_xjal = now_time; break;
    case "dynamic_help": _result_xjal = dynamic_help; break;
    case "connectedag2": _result_xjal = connectedag2; break;
    case "active_safest": _result_xjal = active_safest; break;
    case "static_withdoor_sensor": _result_xjal = static_withdoor_sensor; break;
    case "explosion": _result_xjal = explosion; break;
    case "floor1_agents": _result_xjal = floor1_agents; break;
    case "floor2_agents": _result_xjal = floor2_agents; break;
    case "a1": _result_xjal = a1; break;
    case "a2": _result_xjal = a2; break;
    case "a3": _result_xjal = a3; break;
    case "a4": _result_xjal = a4; break;
    case "coffee_counter": _result_xjal = coffee_counter; break;
    case "total_beforealarm": _result_xjal = total_beforealarm; break;
    case "as1": _result_xjal = as1; break;
    case "as3_2": _result_xjal = as3_2; break;
    case "a3_4": _result_xjal = a3_4; break;
    case "a1_1": _result_xjal = a1_1; break;
    case "a3_2": _result_xjal = a3_2; break;
    default: _result_xjal = super.getParameter( _name_xjal ); break;
    }
    return (T) _result_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private static String[] _parameterNames_xjal;

  @Override
  public String[] getParameterNames() {
    String[] result = _parameterNames_xjal;
    if (result == null) {
      List<String> list = new ArrayList<>( Arrays.asList( super.getParameterNames() ) );
      list.add( "alarmTime" );
      list.add( "visitorArrivalMultiplier" );
      list.add( "addExit" );
      list.add( "workerArrivalRate" );
      list.add( "addExit1" );
      list.add( "active_dynamic" );
      list.add( "safe_exit" );
      list.add( "newvisitorArrivalRate" );
      list.add( "active_predict_help" );
      list.add( "fire_center" );
      list.add( "dis_from_fire" );
      list.add( "fire_speed" );
      list.add( "now_time" );
      list.add( "dynamic_help" );
      list.add( "connectedag2" );
      list.add( "active_safest" );
      list.add( "static_withdoor_sensor" );
      list.add( "explosion" );
      list.add( "floor1_agents" );
      list.add( "floor2_agents" );
      list.add( "a1" );
      list.add( "a2" );
      list.add( "a3" );
      list.add( "a4" );
      list.add( "coffee_counter" );
      list.add( "total_beforealarm" );
      list.add( "as1" );
      list.add( "as3_2" );
      list.add( "a3_4" );
      list.add( "a1_1" );
      list.add( "a3_2" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

 
  public 
double 
 alarmBegining;
 
  public 
boolean 
 alarm;
 
  public 
double 
 alarmEnding;
 
  public 
boolean 
 cafeteriaOpen;
 
  public 
int 
 visitorCount;
 
  public 
double 
 connectionRange;
 
  public 
double 
 connectionsPerAgent;
 
  public 
int 
 scaleFreeM;
 
  public 
double 
 neighborLinkProbability;
 
  public 
boolean 
 finish;
 
  public 
boolean 
 finish1;
 
  public 
int 
 floor_num_main;
 
  public 
double 
 radius;
 
  public 
double 
 radius2;
 
  public 
long 
 dead;
 
  public 
long 
 injured;
 
  public 
double 
 ten_percent;
 
  public 
boolean 
 block;

  // Collection Variables
 
  public 
ArrayList <
Attractor > workTables = new ArrayList<Attractor>();
  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( Main.class );
  
  @AnyLogicInternalCodegenAPI
  @Override
  public Map<String, IElementDescriptor> getElementDesciptors() {
    return elementDesciptors_xjal;
  }
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final Scale scale = new Scale( 10.0 );

  @Override
  public Scale getScale() {
    return scale;
  }


  // Events

  public EventCondition evacuationEnds = new EventCondition(this);
  public EventTimeout closeCafeteria = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _plot_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _visitorsArrivalRate_Action_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _WorkerArrivalRate1_Action_xjal = new EventTimeout(this);

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( EventTimeout _e ) {
     if( _e == closeCafeteria ) return "closeCafeteria";
     if( _e == _plot_autoUpdateEvent_xjal ) return "plot auto update event";
     if( _e == _visitorsArrivalRate_Action_xjal ) return "visitorsArrivalRate action";
     if( _e == _WorkerArrivalRate1_Action_xjal ) return "WorkerArrivalRate1 action";
    return super.getNameOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public EventTimeout.Mode getModeOf( EventTimeout _e ) {
    if ( _e == closeCafeteria ) return EVENT_TIMEOUT_MODE_ONCE;
    if ( _e == _plot_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _visitorsArrivalRate_Action_xjal ) return EVENT_TIMEOUT_MODE_ONCE;
    if ( _e == _WorkerArrivalRate1_Action_xjal ) return EVENT_TIMEOUT_MODE_ONCE;
    return super.getModeOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getFirstOccurrenceTime( EventTimeout _e ) {
    double _t;
    if ( _e == closeCafeteria ) {
      _t = 
10 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _plot_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, MINUTE );
      return _t;
    }
    if ( _e == _visitorsArrivalRate_Action_xjal ) {
      _t = visitorsArrivalRate.getTimeOfValue() == time() ? time() : visitorsArrivalRate.getTimeOfNextValue();
      _t = toModelTime( _t, MINUTE );
      return _t;
    }
    if ( _e == _WorkerArrivalRate1_Action_xjal ) {
      _t = WorkerArrivalRate1.getTimeOfValue() == time() ? time() : WorkerArrivalRate1.getTimeOfNextValue();
      _t = toModelTime( _t, MINUTE );
      return _t;
    }
    return super.getFirstOccurrenceTime( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double evaluateTimeoutOf( EventTimeout _e ) {
    double _t;
    if( _e == _plot_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, MINUTE );
      return _t;
    }
    return super.evaluateTimeoutOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( EventTimeout _e ) {
    if ( _e == closeCafeteria ) {
      EventTimeout self = _e;

cafeteriaOpen = false;
pedEat.freeAll(); 
;
      return;
    }
    if ( _e == _plot_autoUpdateEvent_xjal ) {
      plot.updateData();
      return;
    }
    if ( _e == _visitorsArrivalRate_Action_xjal ) {
      Schedule<Double> self = this.visitorsArrivalRate;
      Double value = visitorsArrivalRate.getValue();
      
 
;
      _visitorsArrivalRate_Action_xjal.restartTo( visitorsArrivalRate.getTimeOfNextValue() );
      return;
    }
    if ( _e == _WorkerArrivalRate1_Action_xjal ) {
      Schedule<Integer> self = this.WorkerArrivalRate1;
      Integer value = WorkerArrivalRate1.getValue();
      
 
;
      _WorkerArrivalRate1_Action_xjal.restartTo( WorkerArrivalRate1.getTimeOfNextValue() );
      return;
    }
    super.executeActionOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( EventCondition _e ) {
    if ( _e == evacuationEnds ) return "evacuationEnds";
    return super.getNameOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean testConditionOf( EventCondition _e ) {

    if ( _e == evacuationEnds) return 
alarm && (finish|| finish1)

//false 
;
    return super.testConditionOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( EventCondition _e ) {
    if ( _e == evacuationEnds) {
      EventCondition self = _e;

getEngine().finish();
alarmEnding = time();

/*
try 
 { 
FileOutputStream fos = new FileOutputStream("Filename.txt");
//FileOutputStream fos = new FileOutputStream("excel111.xlsx");

PrintStream p = new PrintStream(fos);
p.println( evacuation.timeMeasureEnd.dataset.toString()); 
 
 // outputs tab delimited values 
 } 
catch (Exception e) {   
traceln("Could not write to file.");
  }
*/

excel.createCell(1, 1, 1);
excel.createCell(1, 2, 1);
/*if(excel.getCellFormula(1, 1, 1)=="")
{
excel.createCell(1, 1, 1);
excel.setCellValue(timeToString2(alarmBegining), 1, 1, 1);//start
excel.setCellValue(timeToString2(alarmEnding) , 1, 1, 2);//end
excel.setCellValue(total_beforealarm, 1, 1, 3);//totsl num
excel.setCellValue(evacuation.helpsource.out.count(), 1, 1, 4);//help num
excel.setCellValue(evacuation.pedLongWait.in.count(), 1, 1, 5);//trapped
excel.setCellValue(injured, 1, 1, 6);//injured
excel.setCellValue(evacuation.people_helped, 1, 1, 7);//survived with help
excel.setCellValue(evacuation.injured_people_helped, 1, 1, 8);//injured survived with help
excel.setCellValue(dead, 1, 1, 9);//dead
excel.setCellValue(evacuation.pedSink.in.count()-evacuation.people_helper, 1, 1, 10);// only visitor survived
excel.setCellValue(getsuccess_rate()*100, 1, 1, 11);//success rate
excel.setCellValue(alarmEnding - alarmBegining, 1, 1, 12);//duration


}
else{*/
int j=1;int i=2;
for( i=2;excel.getCellNumericValue(1, i, j)!=0;i++ )
{
excel.createCell(1, i, j);
excel.createCell(1, i+1, j);
}
excel.setCellValue(timeToString2(alarmBegining), 1,i , j);
excel.setCellValue(timeToString2(alarmEnding) , 1, i, j+1);
excel.setCellValue(total_beforealarm, 1, i, j+2);//total num
excel.setCellValue(evacuation.helpsource.out.count(), 1, i, j+3);//help num
excel.setCellValue(evacuation.pedLongWait.in.count(), 1, i, j+4);//trapped
excel.setCellValue(injured, 1, i, j+5);//injured
excel.setCellValue(evacuation.people_helped, 1, i, j+6);//survived with help
excel.setCellValue(evacuation.pedSink.in.count()-evacuation.people_helper-evacuation.people_helped, 1, i, j+7);//survived with evacuation;
excel.setCellValue(evacuation.inside_alive, 1, i, j+8);//alived when helper start work
excel.setCellValue(evacuation.injured_people_helped, 1, i, j+9);//injured survived with help
excel.setCellValue(dead, 1, i, j+10);//dead
excel.setCellValue(evacuation.pedSink.in.count()-evacuation.people_helper, 1, i, j+11);//all survived;
excel.setCellValue(getsuccess_rate()*100, 1, i, j+12);//total success rate
excel.setCellValue(((double)evacuation.people_helped / (double)evacuation.inside_alive )*100 ,1 ,i,j+13 ); //help_successRate
excel.setCellValue(((double)(evacuation.pedSink.in.count()-evacuation.people_helper-evacuation.people_helped) / (double)total_beforealarm )*100 ,1 ,i,j+14 ); //evacuee_successRate
excel.setCellValue(alarmEnding - alarmBegining, 1, i, j+15);//duration
//}//else
int k=1; int z=1;
excel1.createCell(1, 1, 1);
while(excel1.getCellNumericValue(1, k, z)!=0)
{z=z+2;
excel1.createCell(1, k, z);
excel1.createCell(1, k, z+1);}
excel1.writeDataSet(evacuation.timeMeasureEnd.dataset, 1, 1,z); 
;
      return ;
    }
    super.executeActionOf( _e );
  }
  

	

  // Dynamic Events 

  /**
   * Creates new dynamic event ChangeNumberOfAgents with given parameter values and schedules in the timeout specified
   * @param _dt the timeout
   * @param n
   * @return created dynamic event instance
   */
  public ChangeNumberOfAgents create_ChangeNumberOfAgents(double _dt , int n ) {
    return new ChangeNumberOfAgents( this, _dt , n );
  }
  
  /**
   * Creates new dynamic event ChangeNumberOfAgents with given parameter values and schedules in the timeout specified
   * @param _dt the timeout
   * @param _units the time units
   * @param n
   * @return created dynamic event instance
   */
  public ChangeNumberOfAgents create_ChangeNumberOfAgents(double _dt, TimeUnits _units , int n ) {
    return new ChangeNumberOfAgents( this, _dt, _units , n );
  } 

  /**
   * Creates new dynamic event ChangeNumberOfAgents with given parameter values and schedules in the timeout specified
   * @param _t the model time (absolute)
   * @param n
   * @return created dynamic event instance
   */
  @AnyLogicInternalAPI
  public ChangeNumberOfAgents create_ChangeNumberOfAgents_absoluteTime_xjal(double _t , int n ) {
    return new ChangeNumberOfAgents( this, _t, true , n );
  } 
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public void on_ChangeNumberOfAgents_xjal(int n ) {

/*while( agents.size() > n )
	remove_agents( agents.get(0) );
while( agents.size() < n ) {
	Agent a = add_agents();
	a.setEnvironment( this );
}

boolean firstApplyLayout =
	(getNetworkType() == NETWORK_ALL_IN_RANGE);

if (firstApplyLayout) {
	applyLayout();
	applyNetwork();
} else {
	applyNetwork();
	applyLayout();
}*/ 
;
  }

  /**
   * Creates new dynamic event Change with given parameter values and schedules in the timeout specified
   * @param _dt the timeout
   * @param n
   * @return created dynamic event instance
   */
  public Change create_Change(double _dt , int n ) {
    return new Change( this, _dt , n );
  }
  
  /**
   * Creates new dynamic event Change with given parameter values and schedules in the timeout specified
   * @param _dt the timeout
   * @param _units the time units
   * @param n
   * @return created dynamic event instance
   */
  public Change create_Change(double _dt, TimeUnits _units , int n ) {
    return new Change( this, _dt, _units , n );
  } 

  /**
   * Creates new dynamic event Change with given parameter values and schedules in the timeout specified
   * @param _t the model time (absolute)
   * @param n
   * @return created dynamic event instance
   */
  @AnyLogicInternalAPI
  public Change create_Change_absoluteTime_xjal(double _t , int n ) {
    return new Change( this, _t, true , n );
  } 
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public void on_Change_xjal(int n ) {

/*while( agents.size() > n )
	remove_agents( agents.get(0) );
while( agents.size() < n ) {
	Agent a = add_agents();
	a.setEnvironment( this );
}

boolean firstApplyLayout =
	(getNetworkType() == NETWORK_ALL_IN_RANGE);

if (firstApplyLayout) {
	applyLayout();
	applyNetwork();
} else {
	applyNetwork();
	applyLayout();
}*/ 
;
  }

  public Schedule<Double> visitorsArrivalRate = new Schedule<Double>(
    this, true, MONDAY, 1L * TIME_UNIT_DAY, TIME_UNIT_DAY, null, 0.0, _visitorsArrivalRate_Starts_xjal(), _visitorsArrivalRate_Ends_xjal(), _visitorsArrivalRate_Values_xjal(), false, null, true );
  public Double visitorsArrivalRate() {
    return visitorsArrivalRate.getValue();
  }
  @AnyLogicInternalCodegenAPI
  private static long[] _visitorsArrivalRate_Starts_xjal() {
    return new long[] { 29400000L, 31500000L, 50400000L, 57600000L, };
  }
  @AnyLogicInternalCodegenAPI
  private static long[] _visitorsArrivalRate_Ends_xjal() {
    return new long[] { 29940000L, 34200000L, 57600000L, 79200000L, };
  }
  @AnyLogicInternalCodegenAPI
  private static Object[] _visitorsArrivalRate_Values_xjal() {
    return new Object[] { 1.5, 1.0, 0.0, 0.0, };
  }

  public Schedule<Integer> WorkerArrivalRate1 = new Schedule<Integer>(
    this, true, MONDAY, 1L * TIME_UNIT_DAY, TIME_UNIT_DAY, null, 0, _WorkerArrivalRate1_Starts_xjal(), _WorkerArrivalRate1_Ends_xjal(), _WorkerArrivalRate1_Values_xjal(), false, null, true );
  public Integer WorkerArrivalRate1() {
    return WorkerArrivalRate1.getValue();
  }
  @AnyLogicInternalCodegenAPI
  private static long[] _WorkerArrivalRate1_Starts_xjal() {
    return new long[] { 28800000L, 39600000L, 50400000L, 57600000L, };
  }
  @AnyLogicInternalCodegenAPI
  private static long[] _WorkerArrivalRate1_Ends_xjal() {
    return new long[] { 31500000L, 50400000L, 57600000L, 79200000L, };
  }
  @AnyLogicInternalCodegenAPI
  private static Object[] _WorkerArrivalRate1_Values_xjal() {
    return new Object[] { 1, 0, 0, 0, };
  }

  // Stub function for code completion support (internal)
  @AnyLogicInternalCodegenAPI
  private void _stubForCodeCompletion_xjal(){
    {double _t = 
0 
;}
    {double _t = 
1 
;}
    class _Stub_Implements_xjal implements 
  {}
    class _Stub_Extends_xjal extends 
  {}
  }

  // Embedded Objects

  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _evacuation_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _myAgent_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _visitor_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
 
  public Evacuation evacuation;
 
  public com.anylogic.libraries.pedestrian.PedSink<
Visitor 
> pedSink;
 
  public com.anylogic.libraries.pedestrian.PedGoTo<
Visitor 
> pedGoToStairs;
 
  public com.anylogic.libraries.processmodeling.SelectOutput<
Visitor 
> selectOutput;
 
  public com.anylogic.libraries.pedestrian.PedSource<
Visitor 
> visitorSource;
 
  public com.anylogic.libraries.pedestrian.PedWait<
Visitor 
> pedEat;
 
  public com.anylogic.libraries.pedestrian.PedGoTo<
Visitor 
> pedGoToExit;
 
  public com.anylogic.libraries.pedestrian.PedSink<
Visitor 
> pedExit;
 
  public com.anylogic.libraries.pedestrian.PedWait<
Visitor 
> pedSmoke;
 
  public com.anylogic.libraries.pedestrian.PedService<
Visitor 
> pedWC;
 
  public com.anylogic.libraries.pedestrian.PedSelectOutput<
OfficeWorker 
> pedSelectOutput;
 
  public com.anylogic.libraries.pedestrian.PedGoTo<
OfficeWorker 
> pedGoToTable;
 
  public com.anylogic.libraries.pedestrian.PedAreaDescriptor<
Visitor 
> pedAreaStairwayUp;
 
  public com.anylogic.libraries.pedestrian.PedSettings pedConfiguration;
 
  public com.anylogic.libraries.pedestrian.PedAreaDescriptor<
Visitor 
> pedAreaStairwayDown;
 
  public com.anylogic.libraries.pedestrian.PedWait<
OfficeWorker 
> pedWork;
 
  public com.anylogic.libraries.processmodeling.Hold<
Visitor 
> hold;
 
  public com.anylogic.libraries.pedestrian.PedChangeGround<
Visitor 
> pedGoToCafeteria;
 
  public com.anylogic.libraries.pedestrian.PedChangeGround<
Visitor 
> pedGoToWork;
 
  public com.anylogic.libraries.processmodeling.SelectOutput<
Visitor 
> selectOutput1;
 
  public com.anylogic.libraries.pedestrian.PedSource<
OfficeWorker 
> visitorSource1;
 
  public com.anylogic.libraries.processmodeling.Hold<
OfficeWorker 
> hold1;
 
  public com.anylogic.libraries.processmodeling.SelectOutput<
Visitor 
> selectOutput2;

  public String getNameOf( Agent ao ) {
    if ( ao == evacuation ) return "evacuation";
    if ( ao == pedSink ) return "pedSink";
    if ( ao == pedGoToStairs ) return "pedGoToStairs";
    if ( ao == selectOutput ) return "selectOutput";
    if ( ao == visitorSource ) return "visitorSource";
    if ( ao == pedEat ) return "pedEat";
    if ( ao == pedGoToExit ) return "pedGoToExit";
    if ( ao == pedExit ) return "pedExit";
    if ( ao == pedSmoke ) return "pedSmoke";
    if ( ao == pedWC ) return "pedWC";
    if ( ao == pedSelectOutput ) return "pedSelectOutput";
    if ( ao == pedGoToTable ) return "pedGoToTable";
    if ( ao == pedAreaStairwayUp ) return "pedAreaStairwayUp";
    if ( ao == pedConfiguration ) return "pedConfiguration";
    if ( ao == pedAreaStairwayDown ) return "pedAreaStairwayDown";
    if ( ao == pedWork ) return "pedWork";
    if ( ao == hold ) return "hold";
    if ( ao == pedGoToCafeteria ) return "pedGoToCafeteria";
    if ( ao == pedGoToWork ) return "pedGoToWork";
    if ( ao == selectOutput1 ) return "selectOutput1";
    if ( ao == visitorSource1 ) return "visitorSource1";
    if ( ao == hold1 ) return "hold1";
    if ( ao == selectOutput2 ) return "selectOutput2";
    return super.getNameOf( ao );
  }

  public AgentAnimationSettings getAnimationSettingsOf( Agent ao ) {
    if ( ao == evacuation ) return _evacuation_animationSettings_xjal;
    return super.getAnimationSettingsOf( ao );
  }

  public class _myAgent_Population extends AgentArrayList<MyAgent> {
    _myAgent_Population( Agent owner ) {
      super( owner );
    }

    @AnyLogicInternalCodegenAPI
    public MyAgent instantiateAgent( int index ) {
    	return instantiate_myAgent_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( MyAgent agent, int index, TableInput tableInput ) {
      setupParameters_myAgent_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( MyAgent agent, int index, TableInput tableInput ) {
      create_myAgent_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return true;
    }

  }
  
 
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "MyAgent")
  public _myAgent_Population myAgent = new _myAgent_Population( this );
  public class _visitor_Population extends AgentArrayList<Visitor> {
    _visitor_Population( Agent owner ) {
      super( owner );
    }

    @AnyLogicInternalCodegenAPI
    public Visitor instantiateAgent( int index ) {
    	return instantiate_visitor_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( Visitor agent, int index, TableInput tableInput ) {
      setupParameters_visitor_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( Visitor agent, int index, TableInput tableInput ) {
      create_visitor_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return true;
    }


    public int visitorStat() {
      return _visitor_visitorStat_xjal();
    }
  }
  
 
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "Visitor")
  public _visitor_Population visitor = new _visitor_Population( this );

  public String getNameOf( AgentList<?> aolist ) {
    if( aolist == myAgent ) return "myAgent";
    if( aolist == visitor ) return "visitor";
    return super.getNameOf( aolist );
  }
  
  public AgentAnimationSettings getAnimationSettingsOf( AgentList<?> aolist ) {
    if( aolist == myAgent ) return _myAgent_animationSettings_xjal;
    if( aolist == visitor ) return _visitor_animationSettings_xjal;
    return super.getAnimationSettingsOf( aolist );
  }

  /**
   * Returns the agent element at the specified position in myAgent
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public MyAgent myAgent(int index) {
    return myAgent.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection myAgent<br>
   * @return newly created embedded object
   */
  public MyAgent add_myAgent() {
    int index = myAgent.size();
    MyAgent _result_xjal = instantiate_myAgent_xjal( index );
    myAgent.callSetupParameters( _result_xjal, index );
    myAgent.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection myAgent<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>myAgent.size()</code> method <strong>before</strong> this method is called
   * @param exits
   * @param waitTime1
   * @param connectedag1
   * @param finished
   * @param times
   * @param alldoor
   * @param dis_from_fire2
   * @param time_to_fire
   * @param allexits
   * @param waitTime2
   * @param name
   * @param n1
   * @param n2
   * @param n3
   * @param n4
   * @param s11
   * @param s12
   * @param s7
   * @param s10
   * @param current
   * @param check
   * @return newly created embedded object
   */
  public MyAgent add_myAgent( ArrayList<TargetLine> exits, double waitTime1, MyAgent[] connectedag1, boolean finished, double times, int alldoor, double[] dis_from_fire2, double[] time_to_fire, ArrayList<TargetLine> allexits, double waitTime2, int name, int n1, int n2, int n3, int n4, MyAgent[] s11, MyAgent[] s12, MyAgent[] s7, MyAgent[] s10, MyAgent[] current, boolean check ) {
    int index = myAgent.size();
    MyAgent _result_xjal = instantiate_myAgent_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.exits = exits;
    _result_xjal.waitTime1 = waitTime1;
    _result_xjal.connectedag1 = connectedag1;
    _result_xjal.finished = finished;
    _result_xjal.times = times;
    _result_xjal.alldoor = alldoor;
    _result_xjal.dis_from_fire2 = dis_from_fire2;
    _result_xjal.time_to_fire = time_to_fire;
    _result_xjal.allexits = allexits;
    _result_xjal.waitTime2 = waitTime2;
    _result_xjal.name = name;
    _result_xjal.n1 = n1;
    _result_xjal.n2 = n2;
    _result_xjal.n3 = n3;
    _result_xjal.n4 = n4;
    _result_xjal.s11 = s11;
    _result_xjal.s12 = s12;
    _result_xjal.s7 = s7;
    _result_xjal.s10 = s10;
    _result_xjal.current = current;
    _result_xjal.check = check;
    // Finish embedded object creation
    myAgent.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection myAgent<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object myAgent - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to myAgent
   */
  public boolean remove_myAgent( MyAgent object ) {
    if( ! myAgent._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    return true;
  }
  /**
   * Returns the agent element at the specified position in visitor
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public Visitor visitor(int index) {
    return visitor.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection visitor<br>
   * @return newly created embedded object
   */
  public Visitor add_visitor() {
    int index = visitor.size();
    Visitor _result_xjal = instantiate_visitor_xjal( index );
    visitor.callSetupParameters( _result_xjal, index );
    visitor.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection visitor<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object visitor - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to visitor
   */
  public boolean remove_visitor( Visitor object ) {
    if( ! visitor._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    return true;
  }

  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected Evacuation instantiate_evacuation_xjal() {
    Evacuation _result_xjal = new Evacuation( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_evacuation_xjal( final Evacuation self ) {
    setupParameters_evacuation_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_evacuation_xjal( Evacuation self ) {
    create_evacuation_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_evacuation_xjal( final Evacuation self, TableInput _t ) {
    self.exits = 
new ArrayList<TargetLine>(){{
	//if(addExit1)
	//if(enter.getColor()!=red)
	 add(enter);
	//else remove(enter);
	
	
	 add(line30);
	// else remove(line30);
}} 
;
    self.condition = 
0 
;
    self.route1 = 
new RectangularNode[]{area2,s1,s3_1,s3_2,s3_3,s5,s4,s8,area1_2,s6,s2,s7,area4};

/*new ArrayList< RectangularNode>(){{
add(s1);
add(s3_1);
add(s3_2);
add(s3_3);
add(s5);
add(s4);
add(s2);
add(s6);
add(s8);
add(s7);//doors + sensors
}} 
//*?*/ 
;
    self.helpee = 
new Visitor [100]//doors + sensors 
;
    self.helper = 
//new  [100]//doors + sensors
new ArrayList< Visitor>(){{
}} 
;
    self.help_source = 
0 
;
    self.time_to_rescue = 
new double [100]//doors + sensors 
;
    self.time_to_death = 
new double [100]//doors + sensors 
;
    self.helper_start_time = 
new double [100]//doors + sensors 
;
    self.helper_targetline = 
new TargetLine [100] 
;
    self.helper_wait = 

new double []{ 
7.388095571
,8.931639737
,7.286458818
,8.595600278
,9.651219981
,9.486350011
,7.325673439
,8.020415117
,9.142920309
,9.795879105
,8.207761539
,9.950720418
,8.680531937
,7.10072435
,8.346301974
,9.754813324
,9.815734987
,9.569297705
,8.806481611
,7.562702298
,9.882806637
,8.788874296
,7.064891934
,7.589528195
,8.870979234
,8.590332241
,7.518325516
,7.804382927
,7.32295225
,7.30725865
,7.319413412
,9.515750414
,8.009751035
,7.192045387
,7.69942869
,7.042124589
,9.98343056
,7.205053155
,9.297245943
,8.332809205
,8.756339557
,8.697590001
,9.729739359
,9.722752871
,7.267748451
,8.935578295
,7.884074517
,7.995903555
,9.889368849
,9.21040632
,8.61165757
,7.202623517
,9.030412738
,7.165669713
,9.962563341
,7.765547768
,8.169031445
,8.482306921
,8.47430304
,7.614456155
,7.276750132
,8.336082442
,9.120137938
,7.765895842
,8.686561739
,8.371142698
,9.123543802
,8.383520831
,9.022047638
,7.708376449
,7.325114152
,8.661596681
,9.607245882
,9.317526324
,9.784402911
,8.788930368
,9.203356109
,9.554275874
,9.545406929
,9.454759276
,9.692195148
,9.395303332
,9.99178333
,8.448222194
,7.564571665
,8.623825279
,7.602250531
,7.039393682
,8.808407004
,8.38608395
,9.239718985
,8.905433699
,9.375311187
,8.03455956
,9.933855157
,9.742396763
,8.770556797
,8.93217971
,7.657996233
,9.560157514

};




 
;
    self.predicted_target = 
 
;
    self.route2 = 
new RectangularNode[]{
area2,s7,area4,s2,s6,area1_2,s8,s4,s5,s3_2,s3_3,s3_1,s1
};
//	new RectangularNode(main.s1,main.s3_1,main.s3_2,main.s3_3,main.s5,main.s4,main.s2,main.s6,main.s8,main.s7)//doors + sensors 
;
    self.route3 = 
new RectangularNode[]{area1_1,s8,area1_2,s6,s2,s7,area4,s1,s3_1,s3_2,s3_3,s5,s4};
//new RectangularNode(main.s1,main.s3_1,main.s3_2,main.s3_3,main.s5,main.s4,main.s2,main.s6,main.s8,main.s7)//doors + sensors 
;
    self.route4 = 
new RectangularNode[]{area1_1,s8,area1_2,s4,s5,s3_2,s3_2,s3_1,s1,area4,s7,s2,s6};
//new RectangularNode(main.s1,main.s3_1,main.s3_2,main.s3_3,main.s5,main.s4,main.s2,main.s6,main.s8,main.s7)//doors + sensors 
;
    self.route5 = 
new RectangularNode[]{area3,area3_2,coffee,null,null,null,null,null,null,null,null,null,null };
//new RectangularNode(main.s1,main.s3_1,main.s3_2,main.s3_3,main.s5,main.s4,main.s2,main.s6,main.s8,main.s7)//doors + sensors 
;
    self.pathways = 
new ArrayList<Pathway>(){{
add(ex1);
add(ex2);
add(office);
add(office1);

}} 
;
    self.temp = 
new double [100]//doors + sensors 
;
    self.injured_helpee = 
new Visitor [100]//doors + sensors 
;
    self.time_end = 
 
;
    self.temp_dtime = 
new double [100]//doors + sensors 
;
    self.helper_recived = 
new double [100]//doors + sensors 
;
    self.helper_to_rescue = 
new double [100]//doors + sensors 
;
    self.helpee_predictdead = 
new double [100]//doors + sensors 
;
    self.helpee_realdead = 
new double [100]//doors + sensors 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_evacuation_xjal( Evacuation self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedSink<Visitor> instantiate_pedSink_xjal() {
    com.anylogic.libraries.pedestrian.PedSink<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedSink<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public void onEnter( Visitor ped ) {
        _pedSink_onEnter_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedSink_xjal( final com.anylogic.libraries.pedestrian.PedSink<Visitor> self ) {
    setupParameters_pedSink_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedSink_xjal( com.anylogic.libraries.pedestrian.PedSink<Visitor> self ) {
    create_pedSink_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedSink_xjal( final com.anylogic.libraries.pedestrian.PedSink<Visitor> self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedSink_xjal( com.anylogic.libraries.pedestrian.PedSink<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedGoTo<Visitor> instantiate_pedGoToStairs_xjal() {
    com.anylogic.libraries.pedestrian.PedGoTo<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedGoTo<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public TargetLine locationLine( Visitor ped ) {
        return _pedGoToStairs_locationLine_xjal( this, ped );
      }
      @Override
      public double locationX( Visitor ped ) {
        return _pedGoToStairs_locationX_xjal( this, ped );
      }
      @Override
      public double locationY( Visitor ped ) {
        return _pedGoToStairs_locationY_xjal( this, ped );
      }
      @Override
      public AreaNode locationArea( Visitor ped ) {
        return _pedGoToStairs_locationArea_xjal( this, ped );
      }
      @Override
      public Pathway route( Visitor ped ) {
        return _pedGoToStairs_route_xjal( this, ped );
      }
      @Override
      public boolean walkInReverseDirection( Visitor ped ) {
        return _pedGoToStairs_walkInReverseDirection_xjal( this, ped );
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedGoToStairs_onEnter_xjal( this, ped );
      }
      @Override
      public void onExit( Visitor ped ) {
        _pedGoToStairs_onExit_xjal( this, ped );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _pedGoToStairs_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( Visitor ped ) {
        _pedGoToStairs_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedGoToStairs_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self ) {
    setupParameters_pedGoToStairs_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedGoToStairs_xjal( com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self ) {
    create_pedGoToStairs_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedGoToStairs_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, TableInput _t ) {
    self.mode = 
self.MODE_REACH_TARGET 
;
    self.locationType = 
self.LOCATION_LINE 
;
    self.reachTolerance = 
0.25 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedGoToStairs_xjal( com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.SelectOutput<Visitor> instantiate_selectOutput_xjal() {
    com.anylogic.libraries.processmodeling.SelectOutput<Visitor> _result_xjal = new com.anylogic.libraries.processmodeling.SelectOutput<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public boolean condition( Visitor agent ) {
        return _selectOutput_condition_xjal( this, agent );
      }
      @Override
      public double probability( Visitor agent ) {
        return _selectOutput_probability_xjal( this, agent );
      }
      @Override
      public void onEnter( Visitor agent ) {
        _selectOutput_onEnter_xjal( this, agent );
      }
      @Override
      public void onExitTrue( Visitor agent ) {
        _selectOutput_onExitTrue_xjal( this, agent );
      }
      @Override
      public void onExitFalse( Visitor agent ) {
        _selectOutput_onExitFalse_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_selectOutput_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self ) {
    setupParameters_selectOutput_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_selectOutput_xjal( com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self ) {
    create_selectOutput_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_selectOutput_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, TableInput _t ) {
    self.conditionIsProbabilistic = 
false 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_selectOutput_xjal( com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedSource<Visitor> instantiate_visitorSource_xjal() {
    com.anylogic.libraries.pedestrian.PedSource<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedSource<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public TargetLine locationLine( Visitor ped ) {
        return _visitorSource_locationLine_xjal( this, ped );
      }
      @Override
      public Ground ground( Visitor ped ) {
        return _visitorSource_ground_xjal( this, ped );
      }
      @Override
      public double locationX( Visitor ped ) {
        return _visitorSource_locationX_xjal( this, ped );
      }
      @Override
      public double locationY( Visitor ped ) {
        return _visitorSource_locationY_xjal( this, ped );
      }
      @Override
      public AreaNode locationArea( Visitor ped ) {
        return _visitorSource_locationArea_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public RateUnits getUnitsForCodeOf_rate() {
        return PER_HOUR;
      }
      @Override
      public double interarrivalTime(  ) {
        return _visitorSource_interarrivalTime_xjal( this );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_interarrivalTime() {
        return SECOND;
      }
      @Override
      public double rateExpression( double baseRate ) {
        return _visitorSource_rateExpression_xjal( this, baseRate );
      }
      @Override
      public Agent newPed(  ) {
        return _visitorSource_newPed_xjal( this );
      }
      @Override
      public double comfortableSpeed( Visitor ped ) {
        return _visitorSource_comfortableSpeed_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public SpeedUnits getUnitsForCodeOf_comfortableSpeed() {
        return MPS;
      }
      @Override
      public double initialSpeed( Visitor ped ) {
        return _visitorSource_initialSpeed_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public SpeedUnits getUnitsForCodeOf_initialSpeed() {
        return MPS;
      }
      @Override
      public double diameter( Visitor ped ) {
        return _visitorSource_diameter_xjal( this, ped );
      }
      @Override
      public int groupSize( Visitor leader ) {
        return _visitorSource_groupSize_xjal( this, leader );
      }
      @Override
      public double groupMemberInterarrivalTime(  ) {
        return _visitorSource_groupMemberInterarrivalTime_xjal( this );
      }
      @Override
      public AgentList population( Visitor ped ) {
        return _visitorSource_population_xjal( this, ped );
      }
      @Override
      public void onExit( Visitor ped ) {
        _visitorSource_onExit_xjal( this, ped );
      }
      @Override
      public void onBeginGrouping( com.anylogic.libraries.pedestrian.PedGroup group, Visitor leader ) {
        _visitorSource_onBeginGrouping_xjal( this, group, leader );
      }
      @Override
      public void onEndGrouping( com.anylogic.libraries.pedestrian.PedGroup group, Visitor leader ) {
        _visitorSource_onEndGrouping_xjal( this, group, leader );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_visitorSource_xjal( final com.anylogic.libraries.pedestrian.PedSource<Visitor> self ) {
    setupParameters_visitorSource_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_visitorSource_xjal( com.anylogic.libraries.pedestrian.PedSource<Visitor> self ) {
    create_visitorSource_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_visitorSource_xjal( final com.anylogic.libraries.pedestrian.PedSource<Visitor> self, TableInput _t ) {
    self.locationType = 
self.LOCATION_LINE 
;
    self.arrivalType = 
self.INTERARRIVAL_TIME 
;
    self.rate = 
60 
;
    self.rateSchedule = 
visitorsArrivalRate 
;
    self.modifyRate = 
false 
;
    self.arrivalSchedule = 
visitorsArrivalRate 
;
    self.limitArrivals = 
false 
;
    self.maxArrivals = 
1000 
;
    self.createGroups = 
false 
;
    self.groupFormation = 
self.GROUP_FORMATION_SWARM 
;
    self.serviceGroupBehavior = 
self.SGB_INDIVIDUAL_SERVING 
;
    self.solidCancelling = 
true 
;
    self.addToCustomPopulation = 
true 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_visitorSource_xjal( com.anylogic.libraries.pedestrian.PedSource<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedWait<Visitor> instantiate_pedEat_xjal() {
    com.anylogic.libraries.pedestrian.PedWait<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedWait<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public AreaNode locationArea( Visitor ped ) {
        return _pedEat_locationArea_xjal( this, ped );
      }
      @Override
      public Attractor attractor( AreaNode areaNode, Visitor ped ) {
        return _pedEat_attractor_xjal( this, areaNode, ped );
      }
      @Override
      public TargetLine locationLine( Visitor ped ) {
        return _pedEat_locationLine_xjal( this, ped );
      }
      @Override
      public double locationX( Visitor ped ) {
        return _pedEat_locationX_xjal( this, ped );
      }
      @Override
      public double locationY( Visitor ped ) {
        return _pedEat_locationY_xjal( this, ped );
      }
      @Override
      public double delayTimeout( Visitor ped ) {
        return _pedEat_delayTimeout_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_delayTimeout() {
        return MINUTE;
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedEat_onEnter_xjal( this, ped );
      }
      @Override
      public void onBeginWait( Visitor ped ) {
        _pedEat_onBeginWait_xjal( this, ped );
      }
      @Override
      public void onExit( Visitor ped ) {
        _pedEat_onExit_xjal( this, ped );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _pedEat_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( Visitor ped ) {
        _pedEat_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedEat_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self ) {
    setupParameters_pedEat_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedEat_xjal( com.anylogic.libraries.pedestrian.PedWait<Visitor> self ) {
    create_pedEat_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedEat_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, TableInput _t ) {
    self.locationType = 
self.LOCATION_AREA 
;
    self.attractorChoice = 
self.ATTRACTOR_CHOICE_FREE 
;
    self.delayType = 
self.DELAY_TIMEOUT 
;
    self.delayStartsWhen = 
self.DELAY_STARTS_SINCE_BEGIN_WAIT 
;
    self.maximumCapacity = 
true 
;
    self.capacity = 
1 
;
    self.targetReachTolerance = 
0.25 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedEat_xjal( com.anylogic.libraries.pedestrian.PedWait<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedGoTo<Visitor> instantiate_pedGoToExit_xjal() {
    com.anylogic.libraries.pedestrian.PedGoTo<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedGoTo<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public TargetLine locationLine( Visitor ped ) {
        return _pedGoToExit_locationLine_xjal( this, ped );
      }
      @Override
      public double locationX( Visitor ped ) {
        return _pedGoToExit_locationX_xjal( this, ped );
      }
      @Override
      public double locationY( Visitor ped ) {
        return _pedGoToExit_locationY_xjal( this, ped );
      }
      @Override
      public AreaNode locationArea( Visitor ped ) {
        return _pedGoToExit_locationArea_xjal( this, ped );
      }
      @Override
      public Pathway route( Visitor ped ) {
        return _pedGoToExit_route_xjal( this, ped );
      }
      @Override
      public boolean walkInReverseDirection( Visitor ped ) {
        return _pedGoToExit_walkInReverseDirection_xjal( this, ped );
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedGoToExit_onEnter_xjal( this, ped );
      }
      @Override
      public void onExit( Visitor ped ) {
        _pedGoToExit_onExit_xjal( this, ped );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _pedGoToExit_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( Visitor ped ) {
        _pedGoToExit_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedGoToExit_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self ) {
    setupParameters_pedGoToExit_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedGoToExit_xjal( com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self ) {
    create_pedGoToExit_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedGoToExit_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, TableInput _t ) {
    self.mode = 
self.MODE_REACH_TARGET 
;
    self.locationType = 
self.LOCATION_LINE 
;
    self.reachTolerance = 
0.25 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedGoToExit_xjal( com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedSink<Visitor> instantiate_pedExit_xjal() {
    com.anylogic.libraries.pedestrian.PedSink<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedSink<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public void onEnter( Visitor ped ) {
        _pedExit_onEnter_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedExit_xjal( final com.anylogic.libraries.pedestrian.PedSink<Visitor> self ) {
    setupParameters_pedExit_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedExit_xjal( com.anylogic.libraries.pedestrian.PedSink<Visitor> self ) {
    create_pedExit_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedExit_xjal( final com.anylogic.libraries.pedestrian.PedSink<Visitor> self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedExit_xjal( com.anylogic.libraries.pedestrian.PedSink<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedWait<Visitor> instantiate_pedSmoke_xjal() {
    com.anylogic.libraries.pedestrian.PedWait<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedWait<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public AreaNode locationArea( Visitor ped ) {
        return _pedSmoke_locationArea_xjal( this, ped );
      }
      @Override
      public Attractor attractor( AreaNode areaNode, Visitor ped ) {
        return _pedSmoke_attractor_xjal( this, areaNode, ped );
      }
      @Override
      public TargetLine locationLine( Visitor ped ) {
        return _pedSmoke_locationLine_xjal( this, ped );
      }
      @Override
      public double locationX( Visitor ped ) {
        return _pedSmoke_locationX_xjal( this, ped );
      }
      @Override
      public double locationY( Visitor ped ) {
        return _pedSmoke_locationY_xjal( this, ped );
      }
      @Override
      public double delayTimeout( Visitor ped ) {
        return _pedSmoke_delayTimeout_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_delayTimeout() {
        return MINUTE;
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedSmoke_onEnter_xjal( this, ped );
      }
      @Override
      public void onBeginWait( Visitor ped ) {
        _pedSmoke_onBeginWait_xjal( this, ped );
      }
      @Override
      public void onExit( Visitor ped ) {
        _pedSmoke_onExit_xjal( this, ped );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _pedSmoke_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( Visitor ped ) {
        _pedSmoke_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedSmoke_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self ) {
    setupParameters_pedSmoke_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedSmoke_xjal( com.anylogic.libraries.pedestrian.PedWait<Visitor> self ) {
    create_pedSmoke_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedSmoke_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, TableInput _t ) {
    self.locationType = 
self.LOCATION_AREA 
;
    self.attractorChoice = 
self.ATTRACTOR_CHOICE_NONE 
;
    self.delayType = 
self.DELAY_TIMEOUT 
;
    self.delayStartsWhen = 
self.DELAY_STARTS_SINCE_BEGIN_WAIT 
;
    self.maximumCapacity = 
true 
;
    self.capacity = 
1 
;
    self.targetReachTolerance = 
0.25 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedSmoke_xjal( com.anylogic.libraries.pedestrian.PedWait<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedService<Visitor> instantiate_pedWC_xjal() {
    com.anylogic.libraries.pedestrian.PedService<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedService<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public QueueUnit chooseQueue( Visitor ped ) {
        return _pedWC_chooseQueue_xjal( this, ped );
      }
      @Override
      public double delayTime( ServiceUnit service, Visitor ped ) {
        return _pedWC_delayTime_xjal( this, service, ped );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_delayTime() {
        return MINUTE;
      }
      @Override
      public double recoveryDelay( ServiceUnit service, Visitor ped ) {
        return _pedWC_recoveryDelay_xjal( this, service, ped );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_recoveryDelay() {
        return MINUTE;
      }
      @Override
      public boolean reverseQueue( Visitor ped ) {
        return _pedWC_reverseQueue_xjal( this, ped );
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedWC_onEnter_xjal( this, ped );
      }
      @Override
      public void onEnterQueue( QueueUnit queue, Visitor ped ) {
        _pedWC_onEnterQueue_xjal( this, queue, ped );
      }
      @Override
      public void onAtExitQueue( QueueUnit queue, Visitor ped ) {
        _pedWC_onAtExitQueue_xjal( this, queue, ped );
      }
      @Override
      public void onExitQueue( QueueUnit queue, Visitor ped ) {
        _pedWC_onExitQueue_xjal( this, queue, ped );
      }
      @Override
      public void onBeginService( ServiceUnit service, Visitor ped ) {
        _pedWC_onBeginService_xjal( this, service, ped );
      }
      @Override
      public void onEndService( ServiceUnit service, Visitor ped ) {
        _pedWC_onEndService_xjal( this, service, ped );
      }
      @Override
      public void onExit( Visitor ped ) {
        _pedWC_onExit_xjal( this, ped );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _pedWC_onCancel_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedWC_xjal( final com.anylogic.libraries.pedestrian.PedService<Visitor> self ) {
    setupParameters_pedWC_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedWC_xjal( com.anylogic.libraries.pedestrian.PedService<Visitor> self ) {
    create_pedWC_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedWC_xjal( final com.anylogic.libraries.pedestrian.PedService<Visitor> self, TableInput _t ) {
    self.services = 
servicesWC 
;
    self.queueChoicePolicy = 
self.CHOICE_CLOSEST_QUEUE 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedWC_xjal( com.anylogic.libraries.pedestrian.PedService<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedSelectOutput<OfficeWorker> instantiate_pedSelectOutput_xjal() {
    com.anylogic.libraries.pedestrian.PedSelectOutput<OfficeWorker> _result_xjal = new com.anylogic.libraries.pedestrian.PedSelectOutput<OfficeWorker>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public boolean condition1( OfficeWorker ped ) {
        return _pedSelectOutput_condition1_xjal( this, ped );
      }
      @Override
      public boolean condition2( OfficeWorker ped ) {
        return _pedSelectOutput_condition2_xjal( this, ped );
      }
      @Override
      public boolean condition3( OfficeWorker ped ) {
        return _pedSelectOutput_condition3_xjal( this, ped );
      }
      @Override
      public boolean condition4( OfficeWorker ped ) {
        return _pedSelectOutput_condition4_xjal( this, ped );
      }
      @Override
      public double probability1( OfficeWorker ped ) {
        return _pedSelectOutput_probability1_xjal( this, ped );
      }
      @Override
      public double probability2( OfficeWorker ped ) {
        return _pedSelectOutput_probability2_xjal( this, ped );
      }
      @Override
      public double probability3( OfficeWorker ped ) {
        return _pedSelectOutput_probability3_xjal( this, ped );
      }
      @Override
      public double probability4( OfficeWorker ped ) {
        return _pedSelectOutput_probability4_xjal( this, ped );
      }
      @Override
      public double probability5( OfficeWorker ped ) {
        return _pedSelectOutput_probability5_xjal( this, ped );
      }
      @Override
      public int exitNumber( OfficeWorker ped ) {
        return _pedSelectOutput_exitNumber_xjal( this, ped );
      }
      @Override
      public void onEnter( OfficeWorker ped ) {
        _pedSelectOutput_onEnter_xjal( this, ped );
      }
      @Override
      public void onExit1( OfficeWorker ped ) {
        _pedSelectOutput_onExit1_xjal( this, ped );
      }
      @Override
      public void onExit2( OfficeWorker ped ) {
        _pedSelectOutput_onExit2_xjal( this, ped );
      }
      @Override
      public void onExit3( OfficeWorker ped ) {
        _pedSelectOutput_onExit3_xjal( this, ped );
      }
      @Override
      public void onExit4( OfficeWorker ped ) {
        _pedSelectOutput_onExit4_xjal( this, ped );
      }
      @Override
      public void onExit5( OfficeWorker ped ) {
        _pedSelectOutput_onExit5_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedSelectOutput_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<OfficeWorker> self ) {
    setupParameters_pedSelectOutput_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedSelectOutput_xjal( com.anylogic.libraries.pedestrian.PedSelectOutput<OfficeWorker> self ) {
    create_pedSelectOutput_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedSelectOutput_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<OfficeWorker> self, TableInput _t ) {
    self.type = 
self.TYPE_CONDITIONS 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedSelectOutput_xjal( com.anylogic.libraries.pedestrian.PedSelectOutput<OfficeWorker> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedGoTo<OfficeWorker> instantiate_pedGoToTable_xjal() {
    com.anylogic.libraries.pedestrian.PedGoTo<OfficeWorker> _result_xjal = new com.anylogic.libraries.pedestrian.PedGoTo<OfficeWorker>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public TargetLine locationLine( OfficeWorker ped ) {
        return _pedGoToTable_locationLine_xjal( this, ped );
      }
      @Override
      public double locationX( OfficeWorker ped ) {
        return _pedGoToTable_locationX_xjal( this, ped );
      }
      @Override
      public double locationY( OfficeWorker ped ) {
        return _pedGoToTable_locationY_xjal( this, ped );
      }
      @Override
      public AreaNode locationArea( OfficeWorker ped ) {
        return _pedGoToTable_locationArea_xjal( this, ped );
      }
      @Override
      public Pathway route( OfficeWorker ped ) {
        return _pedGoToTable_route_xjal( this, ped );
      }
      @Override
      public boolean walkInReverseDirection( OfficeWorker ped ) {
        return _pedGoToTable_walkInReverseDirection_xjal( this, ped );
      }
      @Override
      public void onEnter( OfficeWorker ped ) {
        _pedGoToTable_onEnter_xjal( this, ped );
      }
      @Override
      public void onExit( OfficeWorker ped ) {
        _pedGoToTable_onExit_xjal( this, ped );
      }
      @Override
      public void onCancel( OfficeWorker ped ) {
        _pedGoToTable_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( OfficeWorker ped ) {
        _pedGoToTable_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedGoToTable_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<OfficeWorker> self ) {
    setupParameters_pedGoToTable_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedGoToTable_xjal( com.anylogic.libraries.pedestrian.PedGoTo<OfficeWorker> self ) {
    create_pedGoToTable_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedGoToTable_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<OfficeWorker> self, TableInput _t ) {
    self.mode = 
self.MODE_REACH_TARGET 
;
    self.locationType = 
self.LOCATION_POINT 
;
    self.reachTolerance = 
0.25 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedGoToTable_xjal( com.anylogic.libraries.pedestrian.PedGoTo<OfficeWorker> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedAreaDescriptor<Visitor> instantiate_pedAreaStairwayUp_xjal() {
    com.anylogic.libraries.pedestrian.PedAreaDescriptor<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedAreaDescriptor<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public void onEnter( Visitor ped ) {
        _pedAreaStairwayUp_onEnter_xjal( this, ped );
      }
      @Override
      public void onExit( Visitor ped ) {
        _pedAreaStairwayUp_onExit_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedAreaStairwayUp_xjal( final com.anylogic.libraries.pedestrian.PedAreaDescriptor<Visitor> self ) {
    setupParameters_pedAreaStairwayUp_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedAreaStairwayUp_xjal( com.anylogic.libraries.pedestrian.PedAreaDescriptor<Visitor> self ) {
    create_pedAreaStairwayUp_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedAreaStairwayUp_xjal( final com.anylogic.libraries.pedestrian.PedAreaDescriptor<Visitor> self, TableInput _t ) {
    self.locationArea = 
stairwayUp 
;
    self.speedIsLimited = 
false 
;
    self.maximumSpeed = 
1.0 
;
    self.speedIsMultiplied = 
true 
;
    self.speedFactor = 
0.5 
;
    self.isMoving = 
false 
;
    self.movingSpeed = 
1.0 
;
    self.enableAccessControl = 
false 
;
    self.throughput = 
+infinity 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedAreaStairwayUp_xjal( com.anylogic.libraries.pedestrian.PedAreaDescriptor<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedSettings instantiate_pedConfiguration_xjal() {
    com.anylogic.libraries.pedestrian.PedSettings _result_xjal = new com.anylogic.libraries.pedestrian.PedSettings( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public void onPedSelected( Agent ped ) {
        _pedConfiguration_onPedSelected_xjal( this, ped );
      }
      @Override
      public void onPedDeselected( Agent ped ) {
        _pedConfiguration_onPedDeselected_xjal( this, ped );
      }
      @Override
      public void onGroupAssembled( com.anylogic.libraries.pedestrian.PedGroup group ) {
        _pedConfiguration_onGroupAssembled_xjal( this, group );
      }
      @Override
      public void onGroupDisassembled( com.anylogic.libraries.pedestrian.PedGroup group ) {
        _pedConfiguration_onGroupDisassembled_xjal( this, group );
      }
      @Override
      public void onGroupLeaderChanged( com.anylogic.libraries.pedestrian.PedGroup group, Agent oldLeader, Agent newLeader ) {
        _pedConfiguration_onGroupLeaderChanged_xjal( this, group, oldLeader, newLeader );
      }
      @Override
      public void onGroupFormationChanged( com.anylogic.libraries.pedestrian.PedGroup group, GroupFormation oldFormation, GroupFormation newFormation ) {
        _pedConfiguration_onGroupFormationChanged_xjal( this, group, oldFormation, newFormation );
      }
      @Override
      public void onGroupMemberAdded( com.anylogic.libraries.pedestrian.PedGroup group, Agent ped ) {
        _pedConfiguration_onGroupMemberAdded_xjal( this, group, ped );
      }
      @Override
      public void onGroupMemberRemoved( com.anylogic.libraries.pedestrian.PedGroup group, Agent ped ) {
        _pedConfiguration_onGroupMemberRemoved_xjal( this, group, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedConfiguration_xjal( final com.anylogic.libraries.pedestrian.PedSettings self ) {
    setupParameters_pedConfiguration_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedConfiguration_xjal( com.anylogic.libraries.pedestrian.PedSettings self ) {
    create_pedConfiguration_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedConfiguration_xjal( final com.anylogic.libraries.pedestrian.PedSettings self, TableInput _t ) {
    self.timeStep = 
0.3 
;
    self.allowPedestrianSelectionByClick = 
true 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedConfiguration_xjal( com.anylogic.libraries.pedestrian.PedSettings self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedAreaDescriptor<Visitor> instantiate_pedAreaStairwayDown_xjal() {
    com.anylogic.libraries.pedestrian.PedAreaDescriptor<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedAreaDescriptor<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public void onEnter( Visitor ped ) {
        _pedAreaStairwayDown_onEnter_xjal( this, ped );
      }
      @Override
      public void onExit( Visitor ped ) {
        _pedAreaStairwayDown_onExit_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedAreaStairwayDown_xjal( final com.anylogic.libraries.pedestrian.PedAreaDescriptor<Visitor> self ) {
    setupParameters_pedAreaStairwayDown_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedAreaStairwayDown_xjal( com.anylogic.libraries.pedestrian.PedAreaDescriptor<Visitor> self ) {
    create_pedAreaStairwayDown_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedAreaStairwayDown_xjal( final com.anylogic.libraries.pedestrian.PedAreaDescriptor<Visitor> self, TableInput _t ) {
    self.locationArea = 
stairwayDown 
;
    self.speedIsLimited = 
false 
;
    self.maximumSpeed = 
1.0 
;
    self.speedIsMultiplied = 
true 
;
    self.speedFactor = 
0.7 
;
    self.isMoving = 
false 
;
    self.movingSpeed = 
1.0 
;
    self.enableAccessControl = 
false 
;
    self.throughput = 
+infinity 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedAreaStairwayDown_xjal( com.anylogic.libraries.pedestrian.PedAreaDescriptor<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedWait<OfficeWorker> instantiate_pedWork_xjal() {
    com.anylogic.libraries.pedestrian.PedWait<OfficeWorker> _result_xjal = new com.anylogic.libraries.pedestrian.PedWait<OfficeWorker>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public AreaNode locationArea( OfficeWorker ped ) {
        return _pedWork_locationArea_xjal( this, ped );
      }
      @Override
      public Attractor attractor( AreaNode areaNode, OfficeWorker ped ) {
        return _pedWork_attractor_xjal( this, areaNode, ped );
      }
      @Override
      public TargetLine locationLine( OfficeWorker ped ) {
        return _pedWork_locationLine_xjal( this, ped );
      }
      @Override
      public double locationX( OfficeWorker ped ) {
        return _pedWork_locationX_xjal( this, ped );
      }
      @Override
      public double locationY( OfficeWorker ped ) {
        return _pedWork_locationY_xjal( this, ped );
      }
      @Override
      public double delayTimeout( OfficeWorker ped ) {
        return _pedWork_delayTimeout_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_delayTimeout() {
        return MINUTE;
      }
      @Override
      public void onEnter( OfficeWorker ped ) {
        _pedWork_onEnter_xjal( this, ped );
      }
      @Override
      public void onBeginWait( OfficeWorker ped ) {
        _pedWork_onBeginWait_xjal( this, ped );
      }
      @Override
      public void onExit( OfficeWorker ped ) {
        _pedWork_onExit_xjal( this, ped );
      }
      @Override
      public void onCancel( OfficeWorker ped ) {
        _pedWork_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( OfficeWorker ped ) {
        _pedWork_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedWork_xjal( final com.anylogic.libraries.pedestrian.PedWait<OfficeWorker> self ) {
    setupParameters_pedWork_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedWork_xjal( com.anylogic.libraries.pedestrian.PedWait<OfficeWorker> self ) {
    create_pedWork_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedWork_xjal( final com.anylogic.libraries.pedestrian.PedWait<OfficeWorker> self, TableInput _t ) {
    self.locationType = 
self.LOCATION_AREA 
;
    self.attractorChoice = 
self.ATTRACTOR_CHOICE_CUSTOM 
;
    self.delayType = 
self.DELAY_TIMEOUT 
;
    self.delayStartsWhen = 
self.DELAY_STARTS_SINCE_BEGIN_WAIT 
;
    self.maximumCapacity = 
true 
;
    self.capacity = 
1 
;
    self.targetReachTolerance = 
0.25 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedWork_xjal( com.anylogic.libraries.pedestrian.PedWait<OfficeWorker> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Hold<Visitor> instantiate_hold_xjal() {
    com.anylogic.libraries.processmodeling.Hold<Visitor> _result_xjal = new com.anylogic.libraries.processmodeling.Hold<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public boolean condition( Visitor agent ) {
        return _hold_condition_xjal( this, agent );
      }
      @Override
      public void onEnter( Visitor agent ) {
        _hold_onEnter_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_hold_xjal( final com.anylogic.libraries.processmodeling.Hold<Visitor> self ) {
    setupParameters_hold_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_hold_xjal( com.anylogic.libraries.processmodeling.Hold<Visitor> self ) {
    create_hold_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_hold_xjal( final com.anylogic.libraries.processmodeling.Hold<Visitor> self, TableInput _t ) {
    self.mode = 
self.CONDITIONAL 
;
    self.nEntitiesForSelfBlock = 
1 
;
    self.initiallyBlocked = 
false 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_hold_xjal( com.anylogic.libraries.processmodeling.Hold<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> instantiate_pedGoToCafeteria_xjal() {
    com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedChangeGround<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public TargetLine exitLine( Visitor ped ) {
        return _pedGoToCafeteria_exitLine_xjal( this, ped );
      }
      @Override
      public TargetLine entryLine( Visitor ped ) {
        return _pedGoToCafeteria_entryLine_xjal( this, ped );
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedGoToCafeteria_onEnter_xjal( this, ped );
      }
      @Override
      public void onExitGround( Visitor ped, Ground ground ) {
        _pedGoToCafeteria_onExitGround_xjal( this, ped, ground );
      }
      @Override
      public void onEnterGround( Visitor ped, Ground ground ) {
        _pedGoToCafeteria_onEnterGround_xjal( this, ped, ground );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _pedGoToCafeteria_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( Visitor ped ) {
        _pedGoToCafeteria_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedGoToCafeteria_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self ) {
    setupParameters_pedGoToCafeteria_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedGoToCafeteria_xjal( com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self ) {
    create_pedGoToCafeteria_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedGoToCafeteria_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, TableInput _t ) {
    self.reachTolerance = 
0.25 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedGoToCafeteria_xjal( com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> instantiate_pedGoToWork_xjal() {
    com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedChangeGround<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public TargetLine exitLine( Visitor ped ) {
        return _pedGoToWork_exitLine_xjal( this, ped );
      }
      @Override
      public TargetLine entryLine( Visitor ped ) {
        return _pedGoToWork_entryLine_xjal( this, ped );
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedGoToWork_onEnter_xjal( this, ped );
      }
      @Override
      public void onExitGround( Visitor ped, Ground ground ) {
        _pedGoToWork_onExitGround_xjal( this, ped, ground );
      }
      @Override
      public void onEnterGround( Visitor ped, Ground ground ) {
        _pedGoToWork_onEnterGround_xjal( this, ped, ground );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _pedGoToWork_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( Visitor ped ) {
        _pedGoToWork_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedGoToWork_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self ) {
    setupParameters_pedGoToWork_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedGoToWork_xjal( com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self ) {
    create_pedGoToWork_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedGoToWork_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, TableInput _t ) {
    self.reachTolerance = 
0.25 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedGoToWork_xjal( com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.SelectOutput<Visitor> instantiate_selectOutput1_xjal() {
    com.anylogic.libraries.processmodeling.SelectOutput<Visitor> _result_xjal = new com.anylogic.libraries.processmodeling.SelectOutput<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public boolean condition( Visitor agent ) {
        return _selectOutput1_condition_xjal( this, agent );
      }
      @Override
      public double probability( Visitor agent ) {
        return _selectOutput1_probability_xjal( this, agent );
      }
      @Override
      public void onEnter( Visitor agent ) {
        _selectOutput1_onEnter_xjal( this, agent );
      }
      @Override
      public void onExitTrue( Visitor agent ) {
        _selectOutput1_onExitTrue_xjal( this, agent );
      }
      @Override
      public void onExitFalse( Visitor agent ) {
        _selectOutput1_onExitFalse_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_selectOutput1_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self ) {
    setupParameters_selectOutput1_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_selectOutput1_xjal( com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self ) {
    create_selectOutput1_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_selectOutput1_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, TableInput _t ) {
    self.conditionIsProbabilistic = 
false 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_selectOutput1_xjal( com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected MyAgent instantiate_myAgent_xjal( final int index ) {
    MyAgent _result_xjal = new MyAgent( getEngine(), this, myAgent ) {
      @Override
      @AnyLogicInternalCodegenAPI
      public boolean isLoggingToDB(LoggingType loggingType) {
        return false;
      }

      // Additional class code

 
      // End of additional class code

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_waitTime1() {
        return SECOND;
      }
	};
    
    myAgent._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_myAgent_xjal( final MyAgent self, final int index ) {
    setupParameters_myAgent_xjal( self, index, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_myAgent_xjal( MyAgent self, final int index ) {
    create_myAgent_xjal(self, index, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_myAgent_xjal( final MyAgent self, final int index, TableInput _t ) {
    self.exits = 
new ArrayList<TargetLine>(){{
	//if(addExit1)
	 add(enter);
	//else remove(enter);
	add(line30);
	//add(line20);
	//if (addExit)
	// add(line21);
	 //else remove(line30);
}} 
;
    self.waitTime1 = 
 
;
    self.waitTime1 = SECOND.convertTo( self.waitTime1, MINUTE );
    self.connectedag1 = 
new MyAgent [main.myAgent.size()]//doors + sensors 
;
    self.finished = 
false 
;
    self.times = 
time(MINUTE)-1 
;
    self.alldoor = 
0 
;
    self.dis_from_fire2 = 
new double [main.myAgent.size()]//doors + sensors 
;
    self.time_to_fire = 
new double [main.myAgent.size()]//doors + sensors 
;
    self.allexits = 
new ArrayList<TargetLine>(){{
	//if(addExit1)
	// add(enter);
	//add(line30);
	add(line20);
	add(line21);
	 
}} 
;
    self.waitTime2 = 
0.01 
;
    self.name = 
 
;
    if (_t != null) {
      self.n1 = _t.getValue( "n1", int.class );
    } else {
    self.n1 = 
//doors + sensors 
;
    }
    if (_t != null) {
      self.n2 = _t.getValue( "n2", int.class );
    } else {
    self.n2 = 
//doors + sensors 
;
    }
    if (_t != null) {
      self.n3 = _t.getValue( "n3", int.class );
    } else {
    self.n3 = 
 
;
    }
    if (_t != null) {
      self.n4 = _t.getValue( "n4", int.class );
    } else {
    self.n4 = 
//doors + sensors 
;
    }
    self.s11 = 
new MyAgent [10]//doors + sensors 
;
    self.s12 = 
new MyAgent [10]//doors + sensors 
;
    self.s7 = 
new MyAgent [10]//doors + sensors 
;
    self.s10 = 
new MyAgent [10]//doors + sensors 
;
    self.current = 
new MyAgent [50]//doors + sensors 
;
    if (_t != null) {
      self.check = _t.getValue( "chk", boolean.class );
    } else {
    self.check = 
//doors + sensors 
;
    }
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_myAgent_xjal( MyAgent self, final int index, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
    self.setEnvironment( this );
    if (_t != null) {
      self.setXYZ( _t.getValue( "x", double.class ), _t.getValue( "y", double.class ), 0 );
    } else {
    self.setXYZ( 40.0, 150.0, 0.0 );
    }
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

    // Port connections
  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected Visitor instantiate_visitor_xjal( final int index ) {
    Visitor _result_xjal = new Visitor( getEngine(), this, visitor ) {
      // Additional class code

 
      // End of additional class code
	};
    
    visitor._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_visitor_xjal( final Visitor self, final int index ) {
    setupParameters_visitor_xjal( self, index, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_visitor_xjal( Visitor self, final int index ) {
    create_visitor_xjal(self, index, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_visitor_xjal( final Visitor self, final int index, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_visitor_xjal( Visitor self, final int index, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
    self.setEnvironment( this );
    if (_t != null) {
      self.setXYZ( _t.getValue( "", double.class ), _t.getValue( "timee", double.class ), 0 );
    } else {
    self.setXYZ( 0.0, 0.0, 0.0 );
    }
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

    // Port connections
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedSource<OfficeWorker> instantiate_visitorSource1_xjal() {
    com.anylogic.libraries.pedestrian.PedSource<OfficeWorker> _result_xjal = new com.anylogic.libraries.pedestrian.PedSource<OfficeWorker>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public TargetLine locationLine( OfficeWorker ped ) {
        return _visitorSource1_locationLine_xjal( this, ped );
      }
      @Override
      public Ground ground( OfficeWorker ped ) {
        return _visitorSource1_ground_xjal( this, ped );
      }
      @Override
      public double locationX( OfficeWorker ped ) {
        return _visitorSource1_locationX_xjal( this, ped );
      }
      @Override
      public double locationY( OfficeWorker ped ) {
        return _visitorSource1_locationY_xjal( this, ped );
      }
      @Override
      public AreaNode locationArea( OfficeWorker ped ) {
        return _visitorSource1_locationArea_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public RateUnits getUnitsForCodeOf_rate() {
        return PER_HOUR;
      }
      @Override
      public double interarrivalTime(  ) {
        return _visitorSource1_interarrivalTime_xjal( this );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_interarrivalTime() {
        return SECOND;
      }
      @Override
      public double rateExpression( double baseRate ) {
        return _visitorSource1_rateExpression_xjal( this, baseRate );
      }
      @Override
      public Agent newPed(  ) {
        return _visitorSource1_newPed_xjal( this );
      }
      @Override
      public double comfortableSpeed( OfficeWorker ped ) {
        return _visitorSource1_comfortableSpeed_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public SpeedUnits getUnitsForCodeOf_comfortableSpeed() {
        return MPS;
      }
      @Override
      public double initialSpeed( OfficeWorker ped ) {
        return _visitorSource1_initialSpeed_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public SpeedUnits getUnitsForCodeOf_initialSpeed() {
        return MPS;
      }
      @Override
      public double diameter( OfficeWorker ped ) {
        return _visitorSource1_diameter_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public LengthUnits getUnitsForCodeOf_diameter() {
        return METER;
      }
      @Override
      public int groupSize( OfficeWorker leader ) {
        return _visitorSource1_groupSize_xjal( this, leader );
      }
      @Override
      public double groupMemberInterarrivalTime(  ) {
        return _visitorSource1_groupMemberInterarrivalTime_xjal( this );
      }
      @Override
      public AgentList population( OfficeWorker ped ) {
        return _visitorSource1_population_xjal( this, ped );
      }
      @Override
      public void onExit( OfficeWorker ped ) {
        _visitorSource1_onExit_xjal( this, ped );
      }
      @Override
      public void onBeginGrouping( com.anylogic.libraries.pedestrian.PedGroup group, OfficeWorker leader ) {
        _visitorSource1_onBeginGrouping_xjal( this, group, leader );
      }
      @Override
      public void onEndGrouping( com.anylogic.libraries.pedestrian.PedGroup group, OfficeWorker leader ) {
        _visitorSource1_onEndGrouping_xjal( this, group, leader );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_visitorSource1_xjal( final com.anylogic.libraries.pedestrian.PedSource<OfficeWorker> self ) {
    setupParameters_visitorSource1_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_visitorSource1_xjal( com.anylogic.libraries.pedestrian.PedSource<OfficeWorker> self ) {
    create_visitorSource1_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_visitorSource1_xjal( final com.anylogic.libraries.pedestrian.PedSource<OfficeWorker> self, TableInput _t ) {
    self.locationType = 
self.LOCATION_LINE 
;
    self.arrivalType = 
self.INTERARRIVAL_TIME 
;
    self.rate = 
workerArrivalRate 
;
    self.rateSchedule = 
WorkerArrivalRate1 
;
    self.modifyRate = 
false 
;
    self.arrivalSchedule = 
WorkerArrivalRate1 
;
    self.limitArrivals = 
true 
;
    self.maxArrivals = 
workTables.size()
 
;
    self.createGroups = 
false 
;
    self.groupFormation = 
self.GROUP_FORMATION_SWARM 
;
    self.serviceGroupBehavior = 
self.SGB_INDIVIDUAL_SERVING 
;
    self.solidCancelling = 
true 
;
    self.addToCustomPopulation = 
true 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_visitorSource1_xjal( com.anylogic.libraries.pedestrian.PedSource<OfficeWorker> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Hold<OfficeWorker> instantiate_hold1_xjal() {
    com.anylogic.libraries.processmodeling.Hold<OfficeWorker> _result_xjal = new com.anylogic.libraries.processmodeling.Hold<OfficeWorker>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public boolean condition( OfficeWorker agent ) {
        return _hold1_condition_xjal( this, agent );
      }
      @Override
      public void onEnter( OfficeWorker agent ) {
        _hold1_onEnter_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_hold1_xjal( final com.anylogic.libraries.processmodeling.Hold<OfficeWorker> self ) {
    setupParameters_hold1_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_hold1_xjal( com.anylogic.libraries.processmodeling.Hold<OfficeWorker> self ) {
    create_hold1_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_hold1_xjal( final com.anylogic.libraries.processmodeling.Hold<OfficeWorker> self, TableInput _t ) {
    self.mode = 
self.CONDITIONAL 
;
    self.nEntitiesForSelfBlock = 
1 
;
    self.initiallyBlocked = 
false 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_hold1_xjal( com.anylogic.libraries.processmodeling.Hold<OfficeWorker> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.SelectOutput<Visitor> instantiate_selectOutput2_xjal() {
    com.anylogic.libraries.processmodeling.SelectOutput<Visitor> _result_xjal = new com.anylogic.libraries.processmodeling.SelectOutput<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public boolean condition( Visitor agent ) {
        return _selectOutput2_condition_xjal( this, agent );
      }
      @Override
      public double probability( Visitor agent ) {
        return _selectOutput2_probability_xjal( this, agent );
      }
      @Override
      public void onEnter( Visitor agent ) {
        _selectOutput2_onEnter_xjal( this, agent );
      }
      @Override
      public void onExitTrue( Visitor agent ) {
        _selectOutput2_onExitTrue_xjal( this, agent );
      }
      @Override
      public void onExitFalse( Visitor agent ) {
        _selectOutput2_onExitFalse_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_selectOutput2_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self ) {
    setupParameters_selectOutput2_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_selectOutput2_xjal( com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self ) {
    create_selectOutput2_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_selectOutput2_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, TableInput _t ) {
    self.conditionIsProbabilistic = 
false 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_selectOutput2_xjal( com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }

  private void _pedSink_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedSink<Visitor> self, Visitor ped ) {
    
 
;
  }
  private TargetLine _pedGoToStairs_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
line20 
;
    return _value;
  }
  private double _pedGoToStairs_locationX_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
 
;
    return _value;
  }
  private double _pedGoToStairs_locationY_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
 
;
    return _value;
  }
  private AreaNode _pedGoToStairs_locationArea_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    AreaNode _value;
    _value = 
 
;
    return _value;
  }
  private Pathway _pedGoToStairs_route_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    Pathway _value;
    _value = 
 
;
    return _value;
  }
  private boolean _pedGoToStairs_walkInReverseDirection_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
false 
;
    return _value;
  }
  private void _pedGoToStairs_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
ped.person.setVisible(true);
visitorCount++; 
;
  }
  private void _pedGoToStairs_onExit_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedGoToStairs_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedGoToStairs_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private boolean _selectOutput_condition_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    boolean _value;
    _value = 
cafeteriaOpen 
;
    return _value;
  }
  private double _selectOutput_probability_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    double _value;
    _value = 
0.5 
;
    return _value;
  }
  private void _selectOutput_onEnter_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    
 
;
  }
  private void _selectOutput_onExitTrue_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    
 
;
  }
  private void _selectOutput_onExitFalse_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    
 
;
  }
  private TargetLine _visitorSource_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedSource<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
enter 
;
    return _value;
  }
  private Ground _visitorSource_ground_xjal( final com.anylogic.libraries.pedestrian.PedSource<Visitor> self, Visitor ped ) {
    Ground _value;
    _value = 
pedGroundFirst 
;
    return _value;
  }
  private double _visitorSource_locationX_xjal( final com.anylogic.libraries.pedestrian.PedSource<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
 
;
    return _value;
  }
  private double _visitorSource_locationY_xjal( final com.anylogic.libraries.pedestrian.PedSource<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
 
;
    return _value;
  }
  private AreaNode _visitorSource_locationArea_xjal( final com.anylogic.libraries.pedestrian.PedSource<Visitor> self, Visitor ped ) {
    AreaNode _value;
    _value = 
 
;
    return _value;
  }
  private double _visitorSource_interarrivalTime_xjal( final com.anylogic.libraries.pedestrian.PedSource<Visitor> self ) {
    double _value;
    _value = 
120 
;
    return _value;
  }
  private double _visitorSource_rateExpression_xjal( final com.anylogic.libraries.pedestrian.PedSource<Visitor> self, double baseRate ) {
    double _value;
    _value = 
baseRate * visitorArrivalMultiplier  
;
    return _value;
  }
  private Agent _visitorSource_newPed_xjal( final com.anylogic.libraries.pedestrian.PedSource<Visitor> self ) {
    Agent _value;
    _value = 
new evacuation.Visitor() 
;
    return _value;
  }
  private double _visitorSource_comfortableSpeed_xjal( final com.anylogic.libraries.pedestrian.PedSource<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
//uniform(0.54, 0.8)
0.6 
;
    return _value;
  }
  private double _visitorSource_initialSpeed_xjal( final com.anylogic.libraries.pedestrian.PedSource<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
//uniform(0.5, 0.88)
0.6 
;
    return _value;
  }
  private double _visitorSource_diameter_xjal( final com.anylogic.libraries.pedestrian.PedSource<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
uniform(0.4, 0.5) 
;
    return _value;
  }
  private int _visitorSource_groupSize_xjal( final com.anylogic.libraries.pedestrian.PedSource<Visitor> self, Visitor leader ) {
    int _value;
    _value = 
uniform_discr(2, 3) 
;
    return _value;
  }
  private double _visitorSource_groupMemberInterarrivalTime_xjal( final com.anylogic.libraries.pedestrian.PedSource<Visitor> self ) {
    double _value;
    _value = 
exponential(3) 
;
    return _value;
  }
  private AgentList _visitorSource_population_xjal( final com.anylogic.libraries.pedestrian.PedSource<Visitor> self, Visitor ped ) {
    AgentList _value;
    _value = 
visitor 
;
    return _value;
  }
  private void _visitorSource_onExit_xjal( final com.anylogic.libraries.pedestrian.PedSource<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _visitorSource_onBeginGrouping_xjal( final com.anylogic.libraries.pedestrian.PedSource<Visitor> self, com.anylogic.libraries.pedestrian.PedGroup group, Visitor leader ) {
    
 
;
  }
  private void _visitorSource_onEndGrouping_xjal( final com.anylogic.libraries.pedestrian.PedSource<Visitor> self, com.anylogic.libraries.pedestrian.PedGroup group, Visitor leader ) {
    
 
;
  }
  private AreaNode _pedEat_locationArea_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    AreaNode _value;
    _value = 
cafeteria 
;
    return _value;
  }
  private Attractor _pedEat_attractor_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, AreaNode areaNode, Visitor ped ) {
    Attractor _value;
    _value = 
self.getFreeAttractor(areaNode) 
;
    return _value;
  }
  private TargetLine _pedEat_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
 
;
    return _value;
  }
  private double _pedEat_locationX_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
 
;
    return _value;
  }
  private double _pedEat_locationY_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
 
;
    return _value;
  }
  private double _pedEat_delayTimeout_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
20 
;
    _value = MINUTE.convertTo( _value, SECOND );
    return _value;
  }
  private void _pedEat_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
coffee_counter++ 
;
  }
  private void _pedEat_onBeginWait_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedEat_onExit_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
coffee_counter-- 
;
  }
  private void _pedEat_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedEat_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private TargetLine _pedGoToExit_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
enter 
;
    return _value;
  }
  private double _pedGoToExit_locationX_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
 
;
    return _value;
  }
  private double _pedGoToExit_locationY_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
 
;
    return _value;
  }
  private AreaNode _pedGoToExit_locationArea_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    AreaNode _value;
    _value = 
 
;
    return _value;
  }
  private Pathway _pedGoToExit_route_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    Pathway _value;
    _value = 
 
;
    return _value;
  }
  private boolean _pedGoToExit_walkInReverseDirection_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
false 
;
    return _value;
  }
  private void _pedGoToExit_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedGoToExit_onExit_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedGoToExit_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedGoToExit_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedExit_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedSink<Visitor> self, Visitor ped ) {
    
 
;
  }
  private AreaNode _pedSmoke_locationArea_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    AreaNode _value;
    _value = 
s8 
;
    return _value;
  }
  private Attractor _pedSmoke_attractor_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, AreaNode areaNode, Visitor ped ) {
    Attractor _value;
    _value = 
self.getRandomAttractor(areaNode) 
;
    return _value;
  }
  private TargetLine _pedSmoke_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
 
;
    return _value;
  }
  private double _pedSmoke_locationX_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
 
;
    return _value;
  }
  private double _pedSmoke_locationY_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
 
;
    return _value;
  }
  private double _pedSmoke_delayTimeout_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
6 
;
    _value = MINUTE.convertTo( _value, SECOND );
    return _value;
  }
  private void _pedSmoke_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSmoke_onBeginWait_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSmoke_onExit_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSmoke_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSmoke_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private QueueUnit _pedWC_chooseQueue_xjal( final com.anylogic.libraries.pedestrian.PedService<Visitor> self, Visitor ped ) {
    QueueUnit _value;
    _value = 
 
;
    return _value;
  }
  private double _pedWC_delayTime_xjal( final com.anylogic.libraries.pedestrian.PedService<Visitor> self, ServiceUnit service, Visitor ped ) {
    double _value;
    _value = 
6 
;
    _value = MINUTE.convertTo( _value, SECOND );
    return _value;
  }
  private double _pedWC_recoveryDelay_xjal( final com.anylogic.libraries.pedestrian.PedService<Visitor> self, ServiceUnit service, Visitor ped ) {
    double _value;
    _value = 
1 
;
    _value = MINUTE.convertTo( _value, SECOND );
    return _value;
  }
  private boolean _pedWC_reverseQueue_xjal( final com.anylogic.libraries.pedestrian.PedService<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
false 
;
    return _value;
  }
  private void _pedWC_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedService<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedWC_onEnterQueue_xjal( final com.anylogic.libraries.pedestrian.PedService<Visitor> self, QueueUnit queue, Visitor ped ) {
    
 
;
  }
  private void _pedWC_onAtExitQueue_xjal( final com.anylogic.libraries.pedestrian.PedService<Visitor> self, QueueUnit queue, Visitor ped ) {
    
 
;
  }
  private void _pedWC_onExitQueue_xjal( final com.anylogic.libraries.pedestrian.PedService<Visitor> self, QueueUnit queue, Visitor ped ) {
    
 
;
  }
  private void _pedWC_onBeginService_xjal( final com.anylogic.libraries.pedestrian.PedService<Visitor> self, ServiceUnit service, Visitor ped ) {
    
 
;
  }
  private void _pedWC_onEndService_xjal( final com.anylogic.libraries.pedestrian.PedService<Visitor> self, ServiceUnit service, Visitor ped ) {
    
 
;
  }
  private void _pedWC_onExit_xjal( final com.anylogic.libraries.pedestrian.PedService<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedWC_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedService<Visitor> self, Visitor ped ) {
    
 
;
  }
  private boolean _pedSelectOutput_condition1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<OfficeWorker> self, OfficeWorker ped ) {
    boolean _value;
    _value = 
toTimeUnits(ped.worktime, HOUR) > 7*hour() 
;
    return _value;
  }
  private boolean _pedSelectOutput_condition2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<OfficeWorker> self, OfficeWorker ped ) {
    boolean _value;
    _value = 
ped.isHungry && toTimeUnits(ped.worktime, MINUTE) > 7*minute() && cafeteriaOpen 
;
    return _value;
  }
  private boolean _pedSelectOutput_condition3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<OfficeWorker> self, OfficeWorker ped ) {
    boolean _value;
    _value = 
true 
;
    return _value;
  }
  private boolean _pedSelectOutput_condition4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<OfficeWorker> self, OfficeWorker ped ) {
    boolean _value;
    _value = 

ped.isSmoker && randomTrue(0.4) 
;
    return _value;
  }
  private double _pedSelectOutput_probability1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<OfficeWorker> self, OfficeWorker ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput_probability2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<OfficeWorker> self, OfficeWorker ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput_probability3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<OfficeWorker> self, OfficeWorker ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput_probability4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<OfficeWorker> self, OfficeWorker ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput_probability5_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<OfficeWorker> self, OfficeWorker ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private int _pedSelectOutput_exitNumber_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<OfficeWorker> self, OfficeWorker ped ) {
    int _value;
    _value = 
uniform_discr( 1, 5 ) 
;
    return _value;
  }
  private void _pedSelectOutput_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<OfficeWorker> self, OfficeWorker ped ) {
    
 
;
  }
  private void _pedSelectOutput_onExit1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<OfficeWorker> self, OfficeWorker ped ) {
    
 
;
  }
  private void _pedSelectOutput_onExit2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<OfficeWorker> self, OfficeWorker ped ) {
    
ped.isHungry = false; 
;
  }
  private void _pedSelectOutput_onExit3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<OfficeWorker> self, OfficeWorker ped ) {
    
 
;
  }
  private void _pedSelectOutput_onExit4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<OfficeWorker> self, OfficeWorker ped ) {
    
 
;
  }
  private void _pedSelectOutput_onExit5_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<OfficeWorker> self, OfficeWorker ped ) {
    
 
;
  }
  private TargetLine _pedGoToTable_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<OfficeWorker> self, OfficeWorker ped ) {
    TargetLine _value;
    _value = 
ped.table 
;
    return _value;
  }
  private double _pedGoToTable_locationX_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<OfficeWorker> self, OfficeWorker ped ) {
    double _value;
    _value = 
ped.table.getX() 
;
    return _value;
  }
  private double _pedGoToTable_locationY_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<OfficeWorker> self, OfficeWorker ped ) {
    double _value;
    _value = 
ped.table.getY() 
;
    return _value;
  }
  private AreaNode _pedGoToTable_locationArea_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<OfficeWorker> self, OfficeWorker ped ) {
    AreaNode _value;
    _value = 
 
;
    return _value;
  }
  private Pathway _pedGoToTable_route_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<OfficeWorker> self, OfficeWorker ped ) {
    Pathway _value;
    _value = 
 
;
    return _value;
  }
  private boolean _pedGoToTable_walkInReverseDirection_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<OfficeWorker> self, OfficeWorker ped ) {
    boolean _value;
    _value = 
false 
;
    return _value;
  }
  private void _pedGoToTable_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<OfficeWorker> self, OfficeWorker ped ) {
    
ped.person.setVisible(true); 
;
  }
  private void _pedGoToTable_onExit_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<OfficeWorker> self, OfficeWorker ped ) {
    
 
;
  }
  private void _pedGoToTable_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<OfficeWorker> self, OfficeWorker ped ) {
    
 
;
  }
  private void _pedGoToTable_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<OfficeWorker> self, OfficeWorker ped ) {
    
 
;
  }
  private void _pedAreaStairwayUp_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedAreaDescriptor<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedAreaStairwayUp_onExit_xjal( final com.anylogic.libraries.pedestrian.PedAreaDescriptor<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedConfiguration_onPedSelected_xjal( final com.anylogic.libraries.pedestrian.PedSettings self, Agent ped ) {
    
 
;
  }
  private void _pedConfiguration_onPedDeselected_xjal( final com.anylogic.libraries.pedestrian.PedSettings self, Agent ped ) {
    
 
;
  }
  private void _pedConfiguration_onGroupAssembled_xjal( final com.anylogic.libraries.pedestrian.PedSettings self, com.anylogic.libraries.pedestrian.PedGroup group ) {
    
 
;
  }
  private void _pedConfiguration_onGroupDisassembled_xjal( final com.anylogic.libraries.pedestrian.PedSettings self, com.anylogic.libraries.pedestrian.PedGroup group ) {
    
 
;
  }
  private void _pedConfiguration_onGroupLeaderChanged_xjal( final com.anylogic.libraries.pedestrian.PedSettings self, com.anylogic.libraries.pedestrian.PedGroup group, Agent oldLeader, Agent newLeader ) {
    
 
;
  }
  private void _pedConfiguration_onGroupFormationChanged_xjal( final com.anylogic.libraries.pedestrian.PedSettings self, com.anylogic.libraries.pedestrian.PedGroup group, GroupFormation oldFormation, GroupFormation newFormation ) {
    
 
;
  }
  private void _pedConfiguration_onGroupMemberAdded_xjal( final com.anylogic.libraries.pedestrian.PedSettings self, com.anylogic.libraries.pedestrian.PedGroup group, Agent ped ) {
    
 
;
  }
  private void _pedConfiguration_onGroupMemberRemoved_xjal( final com.anylogic.libraries.pedestrian.PedSettings self, com.anylogic.libraries.pedestrian.PedGroup group, Agent ped ) {
    
 
;
  }
  private void _pedAreaStairwayDown_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedAreaDescriptor<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedAreaStairwayDown_onExit_xjal( final com.anylogic.libraries.pedestrian.PedAreaDescriptor<Visitor> self, Visitor ped ) {
    
 
;
  }
  private AreaNode _pedWork_locationArea_xjal( final com.anylogic.libraries.pedestrian.PedWait<OfficeWorker> self, OfficeWorker ped ) {
    AreaNode _value;
    _value = 
workArea 
;
    return _value;
  }
  private Attractor _pedWork_attractor_xjal( final com.anylogic.libraries.pedestrian.PedWait<OfficeWorker> self, AreaNode areaNode, OfficeWorker ped ) {
    Attractor _value;
    _value = 
ped.table 
;
    return _value;
  }
  private TargetLine _pedWork_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedWait<OfficeWorker> self, OfficeWorker ped ) {
    TargetLine _value;
    _value = 
 
;
    return _value;
  }
  private double _pedWork_locationX_xjal( final com.anylogic.libraries.pedestrian.PedWait<OfficeWorker> self, OfficeWorker ped ) {
    double _value;
    _value = 
ped.table.getX() 
;
    return _value;
  }
  private double _pedWork_locationY_xjal( final com.anylogic.libraries.pedestrian.PedWait<OfficeWorker> self, OfficeWorker ped ) {
    double _value;
    _value = 
ped.table.getY() 
;
    return _value;
  }
  private double _pedWork_delayTimeout_xjal( final com.anylogic.libraries.pedestrian.PedWait<OfficeWorker> self, OfficeWorker ped ) {
    double _value;
    _value = 
//triangular(0.1,0.3,1)//hours
40 
;
    _value = MINUTE.convertTo( _value, SECOND );
    return _value;
  }
  private void _pedWork_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedWait<OfficeWorker> self, OfficeWorker ped ) {
    
ped.worktime += self.delayTimeout(ped) ;  
;
  }
  private void _pedWork_onBeginWait_xjal( final com.anylogic.libraries.pedestrian.PedWait<OfficeWorker> self, OfficeWorker ped ) {
    
 
;
  }
  private void _pedWork_onExit_xjal( final com.anylogic.libraries.pedestrian.PedWait<OfficeWorker> self, OfficeWorker ped ) {
    
 
;
  }
  private void _pedWork_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedWait<OfficeWorker> self, OfficeWorker ped ) {
    
 
;
  }
  private void _pedWork_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedWait<OfficeWorker> self, OfficeWorker ped ) {
    
 
;
  }
  private boolean _hold_condition_xjal( final com.anylogic.libraries.processmodeling.Hold<Visitor> self, Visitor agent ) {
    boolean _value;
    _value = 
block==true 
//|| coffee_counter>=60 
;
    return _value;
  }
  private void _hold_onEnter_xjal( final com.anylogic.libraries.processmodeling.Hold<Visitor> self, Visitor agent ) {
    
 
;
  }
  private TargetLine _pedGoToCafeteria_exitLine_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
line20 
;
    return _value;
  }
  private TargetLine _pedGoToCafeteria_entryLine_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
line21 
;
    return _value;
  }
  private void _pedGoToCafeteria_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedGoToCafeteria_onExitGround_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped, Ground ground ) {
    
 
;
  }
  private void _pedGoToCafeteria_onEnterGround_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped, Ground ground ) {
    
 
;
  }
  private void _pedGoToCafeteria_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedGoToCafeteria_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    
 
;
  }
  private TargetLine _pedGoToWork_exitLine_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
line21 
;
    return _value;
  }
  private TargetLine _pedGoToWork_entryLine_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
line20 
;
    return _value;
  }
  private void _pedGoToWork_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedGoToWork_onExitGround_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped, Ground ground ) {
    
 
;
  }
  private void _pedGoToWork_onEnterGround_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped, Ground ground ) {
    
 
;
  }
  private void _pedGoToWork_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedGoToWork_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    
 
;
  }
  private boolean _selectOutput1_condition_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    boolean _value;
    _value = 
agent instanceof OfficeWorker 
;
    return _value;
  }
  private double _selectOutput1_probability_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    double _value;
    _value = 
0.5 
;
    return _value;
  }
  private void _selectOutput1_onEnter_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    
 
;
  }
  private void _selectOutput1_onExitTrue_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    
 
;
  }
  private void _selectOutput1_onExitFalse_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    
 
;
  }
  private TargetLine _visitorSource1_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedSource<OfficeWorker> self, OfficeWorker ped ) {
    TargetLine _value;
    _value = 
enter 
;
    return _value;
  }
  private Ground _visitorSource1_ground_xjal( final com.anylogic.libraries.pedestrian.PedSource<OfficeWorker> self, OfficeWorker ped ) {
    Ground _value;
    _value = 
pedGroundFirst 
;
    return _value;
  }
  private double _visitorSource1_locationX_xjal( final com.anylogic.libraries.pedestrian.PedSource<OfficeWorker> self, OfficeWorker ped ) {
    double _value;
    _value = 
 
;
    return _value;
  }
  private double _visitorSource1_locationY_xjal( final com.anylogic.libraries.pedestrian.PedSource<OfficeWorker> self, OfficeWorker ped ) {
    double _value;
    _value = 
 
;
    return _value;
  }
  private AreaNode _visitorSource1_locationArea_xjal( final com.anylogic.libraries.pedestrian.PedSource<OfficeWorker> self, OfficeWorker ped ) {
    AreaNode _value;
    _value = 
 
;
    return _value;
  }
  private double _visitorSource1_interarrivalTime_xjal( final com.anylogic.libraries.pedestrian.PedSource<OfficeWorker> self ) {
    double _value;
    _value = 
60 
;
    return _value;
  }
  private double _visitorSource1_rateExpression_xjal( final com.anylogic.libraries.pedestrian.PedSource<OfficeWorker> self, double baseRate ) {
    double _value;
    _value = 
baseRate * visitorArrivalMultiplier  
;
    return _value;
  }
  private Agent _visitorSource1_newPed_xjal( final com.anylogic.libraries.pedestrian.PedSource<OfficeWorker> self ) {
    Agent _value;
    _value = 
new OfficeWorker(workTables.get((int)self.countPeds())) 
;
    return _value;
  }
  private double _visitorSource1_comfortableSpeed_xjal( final com.anylogic.libraries.pedestrian.PedSource<OfficeWorker> self, OfficeWorker ped ) {
    double _value;
    _value = 
//uniform(0.54, 0.8)
0.6 
;
    return _value;
  }
  private double _visitorSource1_initialSpeed_xjal( final com.anylogic.libraries.pedestrian.PedSource<OfficeWorker> self, OfficeWorker ped ) {
    double _value;
    _value = 
//uniform(0.5, 0.7)
0.6 
;
    return _value;
  }
  private double _visitorSource1_diameter_xjal( final com.anylogic.libraries.pedestrian.PedSource<OfficeWorker> self, OfficeWorker ped ) {
    double _value;
    _value = 
uniform(0.4, 0.5) 
;
    return _value;
  }
  private int _visitorSource1_groupSize_xjal( final com.anylogic.libraries.pedestrian.PedSource<OfficeWorker> self, OfficeWorker leader ) {
    int _value;
    _value = 
uniform_discr(2, 3) 
;
    return _value;
  }
  private double _visitorSource1_groupMemberInterarrivalTime_xjal( final com.anylogic.libraries.pedestrian.PedSource<OfficeWorker> self ) {
    double _value;
    _value = 
exponential(3) 
;
    return _value;
  }
  private AgentList _visitorSource1_population_xjal( final com.anylogic.libraries.pedestrian.PedSource<OfficeWorker> self, OfficeWorker ped ) {
    AgentList _value;
    _value = 
visitor 
;
    return _value;
  }
  private void _visitorSource1_onExit_xjal( final com.anylogic.libraries.pedestrian.PedSource<OfficeWorker> self, OfficeWorker ped ) {
    
//ped.isHungry=randomTrue(0.6);
ped.isSmoker = randomTrue(0.5); 
;
  }
  private void _visitorSource1_onBeginGrouping_xjal( final com.anylogic.libraries.pedestrian.PedSource<OfficeWorker> self, com.anylogic.libraries.pedestrian.PedGroup group, OfficeWorker leader ) {
    
 
;
  }
  private void _visitorSource1_onEndGrouping_xjal( final com.anylogic.libraries.pedestrian.PedSource<OfficeWorker> self, com.anylogic.libraries.pedestrian.PedGroup group, OfficeWorker leader ) {
    
 
;
  }
  private boolean _hold1_condition_xjal( final com.anylogic.libraries.processmodeling.Hold<OfficeWorker> self, OfficeWorker agent ) {
    boolean _value;
    _value = 
block 
;
    return _value;
  }
  private void _hold1_onEnter_xjal( final com.anylogic.libraries.processmodeling.Hold<OfficeWorker> self, OfficeWorker agent ) {
    
 
;
  }
  private boolean _selectOutput2_condition_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    boolean _value;
    _value = 
cafeteriaOpen 
;
    return _value;
  }
  private double _selectOutput2_probability_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    double _value;
    _value = 
0.5 
;
    return _value;
  }
  private void _selectOutput2_onEnter_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    
 
;
  }
  private void _selectOutput2_onExitTrue_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    
 
;
  }
  private void _selectOutput2_onExitFalse_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    
 
;
  }
  /**
   * <i>This method should not be called by user</i>
   */
  private int _visitor_visitorStat_xjal() {
    int _value = 0;
    for ( Visitor item : visitor ) {
      boolean _t = 
 
;
      if ( _t ) {
        _value++;
      }
    }
    return _value;
  }
  // Functions

 
  
long 
 getPeopleInsideCount(  ) { 

evacuation.peopleinside=hold1.out.count()  + visitorCount +evacuation.helpsource.out.count()  - pedSink.sink.count() - pedExit.sink.count() - evacuation.pedSink.sink.count();

long x= evacuation.peopleinside;
return x;
//5 sink + 2 src in main+ 1src in evac
//workerSource.countPeds() + visitorCount - pedSink.sink.count() - pedExit.sink.count() - evacuation.pedSink.sink.count(); 
  }

 
  
double 
 getEvacuationTime(  ) { 

return (alarmEnding == 0 ? (time() - alarmBegining)/second() : (alarmEnding - alarmBegining)/second()); 
  }

 
  
String 
 timeToString( double minutes ) { 

Date date = timeToDate(minutes);
int hour = getHourOfDay(date);
int minute = getMinute(date);
String hourToString = hour < 10 ? "0" + hour : hour + "";
String minuteToString = minute < 10 ? "0" + minute : minute + "";
return hourToString + ":" + minuteToString; 
  }

 
  void refreshNetwork(  ) { 

switch( radioNetworkType.getValue() ) {
case 0:
	setNetworkUserDefined();
	break;
case 1:
	setNetworkRandom( connectionsPerAgent );
	break;
case 2:
	setNetworkAllInRange( connectionRange );
	break;
case 3:
	setNetworkRingLattice( (int)connectionsPerAgent );
	break;
case 4:
	setNetworkSmallWorld( (int)connectionsPerAgent, neighborLinkProbability );
	break;
case 5:
	setNetworkScaleFree( scaleFreeM );
	break;
}
applyNetwork(); 
  }

 
  void setNumberOfAgents( int n ) { 

create_ChangeNumberOfAgents( 0, n ); 
  }

 
  void firealarmfunc(  ) { 

total_beforealarm=getPeopleInsideCount();
alarm = true;
cafeteriaOpen=false;
visitorSource.set_limitArrivals(true);
visitorSource.set_maxArrivals(visitorSource.countPeds());

visitorSource1.set_limitArrivals(true);
visitorSource1.set_maxArrivals(0);

getEngine().setRealTimeMode(true);
getEngine().setRealTimeScale(1);


alarmBegining = time();
//checkbox.setEnabled(false);
pedGoToCafeteria.cancelAll();
pedGoToWork.cancelAll();
pedGoToStairs.cancelAll();
pedGoToExit.cancelAll();
pedGoToTable.cancelAll();
pedWork.cancelAll();
pedWC.cancelAll();
pedEat.cancelAll();
pedSmoke.cancelAll();
ten_percent=getPeopleInsideCount()*0.1;

//workerSource.set_rate(0);
//evacuationStart.add(time(),0);
evacuationStart.add(time(),getPeopleInsideCount());

//blind helper
//if(!dynamic_help&& active_dynamic){
if(!dynamic_help){
	for(int i=0;i<getPeopleInsideCount()*0.3;i++)
	{
	//evacuation.helper_wait[evacuation.ind]=uniform(7, 10);
	if(static_withdoor_sensor==true)
		if(line30.getColor()==red)
		evacuation.helper_targetline[evacuation.ind]=enter;
		else
		evacuation.helper_targetline[evacuation.ind]=line30;
	else{	
	if(randomTrue(0.5))
	evacuation.helper_targetline[evacuation.ind]=enter;
	else
	evacuation.helper_targetline[evacuation.ind]=line30;
	}
	
	evacuation.ind++;
	evacuation.helpsource.inject(1);
	 
	}
}//blind help
else
alarm=true;

 
  }

 
  
double 
 getsuccess_rate(  ) { 


double x=((double)evacuation.pedSink.in.count()-(double)evacuation.people_helper )/ (double)total_beforealarm;
//string s=toString(x);
return x;//5 sink + 2 src in main+ 1src in evac
//workerSource.countPeds() + visitorCount - pedSink.sink.count() - pedExit.sink.count() - evacuation.pedSink.sink.count(); 
  }

 
  
double 
 timeToString2( double minutes ) { 

Date date = timeToDate(minutes);
int hour = getHourOfDay(date);
int minute = getMinute(date);
String hourToString = hour < 10 ? "0" + hour : hour + "";
String minuteToString = minute < 10 ? "0" + minute : minute + "";
double min=(double)minute/100;
double d=(double)hour+(double)min;

return d;
//return hourToString + "." + minuteToString; 
  }
  // Analysis Data Elements
  @AnyLogicInternalCodegenAPI
  public DataSet _plot_expression0_dataSet_xjal = new DataSet( 100, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( DataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), __plot_expression0_dataSet_xjal_YValue() );
      _lastUpdateX = time();
    }
  } );
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __plot_expression0_dataSet_xjal_YValue() {
    return 
getsuccess_rate()*100 
;
  }

  @AnyLogicInternalCodegenAPI
  public DataSet _plot_expression1_dataSet_xjal = new DataSet( 100, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( DataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), __plot_expression1_dataSet_xjal_YValue() );
      _lastUpdateX = time();
    }
  } );
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __plot_expression1_dataSet_xjal_YValue() {
    return 
getPeopleInsideCount() 
;
  }

  public DataSet evacuationStart = new DataSet( 1000, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( DataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( _evacuationStart_XValue(), _evacuationStart_YValue() );
      _lastUpdateX = time();
    }
  } );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _evacuationStart_XValue() {
    return 
 
;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _evacuationStart_YValue() {
    return 
 
;
  }
  
  public double evacTime;
  public void update_evacTime() {
    evacTime = 
alarmEnding - alarmBegining ;
  }
  public void update_evacTime(double _value) {
    evacTime = _value;
  }

  // View areas
  public ViewArea viewArea = new ViewArea( this, null, 0, 0, 1210, 1130 );
  public ViewArea _origin_VA = new ViewArea( this, "[Origin]", 0, 0, 1270.0, 910.0 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "viewArea", this.viewArea );
      _output.put( "_origin_VA", this._origin_VA );
    }
    return 2 + super.getViewAreas( _output );
  }
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_Font = new Font("SansSerif", 1, 16 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _radioLayoutType_Font = _checkbox_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _radioNetworkType_Font = _checkbox_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _radio_Font = _checkbox_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox1_Font = _checkbox_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox2_Font = _checkbox_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox4_Font = _checkbox_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox5_Font = _checkbox_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox6_Font = _checkbox_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text2_Font = new Font("OCR A Extended", 0, 24 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text3_Font = new Font("SansSerif", 0, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _textHead_Font = new Font("SansSerif", 0, 28 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text4_Font = new Font("SansSerif", 1, 22 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text5_Font = _text4_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text6_Font = _text3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text7_Font = _text4_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text9_Font = _text4_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text11_Font = _text3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text12_Font = _text4_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text13_Font = new Font("SansSerif", 1, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text14_Font = _text13_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text15_Font = _text13_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text16_Font = _text13_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text17_Font = _text13_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text8_Font = _text4_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text10_Font = new Font("SansSerif", 1, 18 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text20_Font = _text3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text21_Font = _text2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text18_Font = new Font("SansSerif", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text22_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text23_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text24_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text25_Font = _text13_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text26_Font = _text13_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text27_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text28_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text29_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text30_Font = _text18_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text31_Font = _text3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text32_Font = _text2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text33_Font = _text3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text34_Font = _text2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text35_Font = _text3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text38_Font = _text3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text39_Font = _text2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text36_Font = _text3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text40_Font = _text2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text41_Font = _text3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text37_Font = _text3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text42_Font = _text2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text44_Font = _text3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text_Font = _text2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text1_Font = _text3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text45_Font = _text3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text46_Font = _text3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text43_Font = _text10_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text47_Font = _text3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _success_Font = _text2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text48_Font = _text2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text49_Font = _text3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text50_Font = _text2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text51_Font = _text3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text52_Font = _text3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text53_Font = _text2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text54_Font = _text2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text55_Font = _text3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text56_Font = _text3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _helper_success_Font = _text2_Font;
  protected static final Color _button_Text_Color = new Color( 0xFFDC0000, true );
  protected static final Color _rectangle9_Fill_Color = new Color( 0xFFE6EAEF, true );
  protected static final Color _polyline2_Fill_Color = new Color( 0xFF1BA607, true );
  protected static final Color _oval12_Fill_Color = new Color( 0x539ACD32, true );
  protected static final Color _oval13_Fill_Color = new Color( 0x53FFFF00, true );
  protected static final Color _polyline3_Fill_Color = new Color( 0xFF1BA607, true );
  protected static final Color _oval14_Fill_Color = new Color( 0x53FFFF00, true );
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _button = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _sliderRange = 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _radioLayoutType = 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _radioNetworkType = 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _sliderConnectionsPerAgent = 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _sliderNeighborLinkProb = 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _sliderScaleFreeM = 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _radio = 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox1 = 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox2 = 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox4 = 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox5 = 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox6 = 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _groupFloor1 = 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _groupDinnerTable = 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _groupFloor2 = 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _text2 = 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _text3 = 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle1 = 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline = 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _line = 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _line1 = 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _line2 = 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _line3 = 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _line4 = 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _line5 = 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _line6 = 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _line7 = 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _line8 = 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _line9 = 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _line10 = 32;
  @AnyLogicInternalCodegenAPI
  protected static final int _line11 = 33;
  @AnyLogicInternalCodegenAPI
  protected static final int _line12 = 34;
  @AnyLogicInternalCodegenAPI
  protected static final int _line13 = 35;
  @AnyLogicInternalCodegenAPI
  protected static final int _line14 = 36;
  @AnyLogicInternalCodegenAPI
  protected static final int _line15 = 37;
  @AnyLogicInternalCodegenAPI
  protected static final int _line16 = 38;
  @AnyLogicInternalCodegenAPI
  protected static final int _line17 = 39;
  @AnyLogicInternalCodegenAPI
  protected static final int _line18 = 40;
  @AnyLogicInternalCodegenAPI
  protected static final int _line19 = 41;
  @AnyLogicInternalCodegenAPI
  protected static final int _line31 = 42;
  @AnyLogicInternalCodegenAPI
  protected static final int _line32 = 43;
  @AnyLogicInternalCodegenAPI
  protected static final int _line33 = 44;
  @AnyLogicInternalCodegenAPI
  protected static final int _line34 = 45;
  @AnyLogicInternalCodegenAPI
  protected static final int _line35 = 46;
  @AnyLogicInternalCodegenAPI
  protected static final int _line36 = 47;
  @AnyLogicInternalCodegenAPI
  protected static final int _groupSt1 = 48;
  @AnyLogicInternalCodegenAPI
  protected static final int _line37 = 49;
  @AnyLogicInternalCodegenAPI
  protected static final int _line38 = 50;
  @AnyLogicInternalCodegenAPI
  protected static final int _line39 = 51;
  @AnyLogicInternalCodegenAPI
  protected static final int _line40 = 52;
  @AnyLogicInternalCodegenAPI
  protected static final int _line41 = 53;
  @AnyLogicInternalCodegenAPI
  protected static final int _line42 = 54;
  @AnyLogicInternalCodegenAPI
  protected static final int _line43 = 55;
  @AnyLogicInternalCodegenAPI
  protected static final int _line44 = 56;
  @AnyLogicInternalCodegenAPI
  protected static final int _line45 = 57;
  @AnyLogicInternalCodegenAPI
  protected static final int _line46 = 58;
  @AnyLogicInternalCodegenAPI
  protected static final int _line47 = 59;
  @AnyLogicInternalCodegenAPI
  protected static final int _line48 = 60;
  @AnyLogicInternalCodegenAPI
  protected static final int _line49 = 61;
  @AnyLogicInternalCodegenAPI
  protected static final int _line50 = 62;
  @AnyLogicInternalCodegenAPI
  protected static final int _line51 = 63;
  @AnyLogicInternalCodegenAPI
  protected static final int _line52 = 64;
  @AnyLogicInternalCodegenAPI
  protected static final int _groupSt2 = 65;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle2 = 66;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle9 = 67;
  @AnyLogicInternalCodegenAPI
  protected static final int _line53 = 68;
  @AnyLogicInternalCodegenAPI
  protected static final int _textHead = 69;
  @AnyLogicInternalCodegenAPI
  protected static final int _groupMainMenu = 70;
  @AnyLogicInternalCodegenAPI
  protected static final int _text4 = 71;
  @AnyLogicInternalCodegenAPI
  protected static final int _text5 = 72;
  @AnyLogicInternalCodegenAPI
  protected static final int _evacuation_presentation = 73;
  @AnyLogicInternalCodegenAPI
  protected static final int _text6 = 74;
  @AnyLogicInternalCodegenAPI
  protected static final int _text7 = 75;
  @AnyLogicInternalCodegenAPI
  protected static final int _text9 = 76;
  @AnyLogicInternalCodegenAPI
  protected static final int _text11 = 77;
  @AnyLogicInternalCodegenAPI
  protected static final int _text12 = 78;
  @AnyLogicInternalCodegenAPI
  protected static final int _text13 = 79;
  @AnyLogicInternalCodegenAPI
  protected static final int _line72 = 80;
  @AnyLogicInternalCodegenAPI
  protected static final int _text14 = 81;
  @AnyLogicInternalCodegenAPI
  protected static final int _line73 = 82;
  @AnyLogicInternalCodegenAPI
  protected static final int _text15 = 83;
  @AnyLogicInternalCodegenAPI
  protected static final int _line85 = 84;
  @AnyLogicInternalCodegenAPI
  protected static final int _line86 = 85;
  @AnyLogicInternalCodegenAPI
  protected static final int _text16 = 86;
  @AnyLogicInternalCodegenAPI
  protected static final int _line87 = 87;
  @AnyLogicInternalCodegenAPI
  protected static final int _text17 = 88;
  @AnyLogicInternalCodegenAPI
  protected static final int _text8 = 89;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline2 = 90;
  @AnyLogicInternalCodegenAPI
  protected static final int _text10 = 91;
  @AnyLogicInternalCodegenAPI
  protected static final int _group2 = 92;
  @AnyLogicInternalCodegenAPI
  protected static final int _text20 = 93;
  @AnyLogicInternalCodegenAPI
  protected static final int _text21 = 94;
  @AnyLogicInternalCodegenAPI
  protected static final int _text18 = 95;
  @AnyLogicInternalCodegenAPI
  protected static final int _text22 = 96;
  @AnyLogicInternalCodegenAPI
  protected static final int _text23 = 97;
  @AnyLogicInternalCodegenAPI
  protected static final int _text24 = 98;
  @AnyLogicInternalCodegenAPI
  protected static final int _line22 = 99;
  @AnyLogicInternalCodegenAPI
  protected static final int _text25 = 100;
  @AnyLogicInternalCodegenAPI
  protected static final int _line23 = 101;
  @AnyLogicInternalCodegenAPI
  protected static final int _text26 = 102;
  @AnyLogicInternalCodegenAPI
  protected static final int _text27 = 103;
  @AnyLogicInternalCodegenAPI
  protected static final int _text28 = 104;
  @AnyLogicInternalCodegenAPI
  protected static final int _text29 = 105;
  @AnyLogicInternalCodegenAPI
  protected static final int _text30 = 106;
  @AnyLogicInternalCodegenAPI
  protected static final int _myAgent_presentation = 107;
  @AnyLogicInternalCodegenAPI
  protected static final int _text31 = 108;
  @AnyLogicInternalCodegenAPI
  protected static final int _text32 = 109;
  @AnyLogicInternalCodegenAPI
  protected static final int _visitor_presentation = 110;
  @AnyLogicInternalCodegenAPI
  protected static final int _text33 = 111;
  @AnyLogicInternalCodegenAPI
  protected static final int _text34 = 112;
  @AnyLogicInternalCodegenAPI
  protected static final int _text35 = 113;
  @AnyLogicInternalCodegenAPI
  protected static final int _text38 = 114;
  @AnyLogicInternalCodegenAPI
  protected static final int _text39 = 115;
  @AnyLogicInternalCodegenAPI
  protected static final int _text36 = 116;
  @AnyLogicInternalCodegenAPI
  protected static final int _text40 = 117;
  @AnyLogicInternalCodegenAPI
  protected static final int _text41 = 118;
  @AnyLogicInternalCodegenAPI
  protected static final int _text37 = 119;
  @AnyLogicInternalCodegenAPI
  protected static final int _text42 = 120;
  @AnyLogicInternalCodegenAPI
  protected static final int _text44 = 121;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle3 = 122;
  @AnyLogicInternalCodegenAPI
  protected static final int _text = 123;
  @AnyLogicInternalCodegenAPI
  protected static final int _text1 = 124;
  @AnyLogicInternalCodegenAPI
  protected static final int _text45 = 125;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval12 = 126;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval13 = 127;
  @AnyLogicInternalCodegenAPI
  protected static final int _text46 = 128;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline3 = 129;
  @AnyLogicInternalCodegenAPI
  protected static final int _text43 = 130;
  @AnyLogicInternalCodegenAPI
  protected static final int _group4 = 131;
  @AnyLogicInternalCodegenAPI
  protected static final int _text47 = 132;
  @AnyLogicInternalCodegenAPI
  protected static final int _success = 133;
  @AnyLogicInternalCodegenAPI
  protected static final int _text48 = 134;
  @AnyLogicInternalCodegenAPI
  protected static final int _text49 = 135;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval14 = 136;
  @AnyLogicInternalCodegenAPI
  protected static final int _text50 = 137;
  @AnyLogicInternalCodegenAPI
  protected static final int _text51 = 138;
  @AnyLogicInternalCodegenAPI
  protected static final int _text52 = 139;
  @AnyLogicInternalCodegenAPI
  protected static final int _text53 = 140;
  @AnyLogicInternalCodegenAPI
  protected static final int _text54 = 141;
  @AnyLogicInternalCodegenAPI
  protected static final int _text55 = 142;
  @AnyLogicInternalCodegenAPI
  protected static final int _text56 = 143;
  @AnyLogicInternalCodegenAPI
  protected static final int _helper_success = 144;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot = 145;
  @AnyLogicInternalCodegenAPI
  protected static final int _enter = 146;
  @AnyLogicInternalCodegenAPI
  protected static final int _line20 = 147;
  @AnyLogicInternalCodegenAPI
  protected static final int _s8 = 148;
  @AnyLogicInternalCodegenAPI
  protected static final int _stairwayUp = 149;
  @AnyLogicInternalCodegenAPI
  protected static final int _line30 = 150;
  @AnyLogicInternalCodegenAPI
  protected static final int _queueLine = 151;
  @AnyLogicInternalCodegenAPI
  protected static final int _servicePoint = 152;
  @AnyLogicInternalCodegenAPI
  protected static final int _servicePoint3 = 153;
  @AnyLogicInternalCodegenAPI
  protected static final int _servicePoint4 = 154;
  @AnyLogicInternalCodegenAPI
  protected static final int _servicePoint5 = 155;
  @AnyLogicInternalCodegenAPI
  protected static final int _servicesWC = 156;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline5 = 157;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline6 = 158;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline7 = 159;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline8 = 160;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline9 = 161;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline10 = 162;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline11 = 163;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline12 = 164;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline13 = 165;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline16 = 166;
  @AnyLogicInternalCodegenAPI
  protected static final int _table6 = 167;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline17 = 168;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline18 = 169;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline20 = 170;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline21 = 171;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline22 = 172;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline24 = 173;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline25 = 174;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline26 = 175;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline27 = 176;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline28 = 177;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline29 = 178;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline30 = 179;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline31 = 180;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline38 = 181;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline39 = 182;
  @AnyLogicInternalCodegenAPI
  protected static final int _wall = 183;
  @AnyLogicInternalCodegenAPI
  protected static final int _seat7 = 184;
  @AnyLogicInternalCodegenAPI
  protected static final int _seat8 = 185;
  @AnyLogicInternalCodegenAPI
  protected static final int _seat9 = 186;
  @AnyLogicInternalCodegenAPI
  protected static final int _seat10 = 187;
  @AnyLogicInternalCodegenAPI
  protected static final int _seat11 = 188;
  @AnyLogicInternalCodegenAPI
  protected static final int _seat12 = 189;
  @AnyLogicInternalCodegenAPI
  protected static final int _seat13 = 190;
  @AnyLogicInternalCodegenAPI
  protected static final int _seat14 = 191;
  @AnyLogicInternalCodegenAPI
  protected static final int _seat15 = 192;
  @AnyLogicInternalCodegenAPI
  protected static final int _seat16 = 193;
  @AnyLogicInternalCodegenAPI
  protected static final int _seat17 = 194;
  @AnyLogicInternalCodegenAPI
  protected static final int _seat18 = 195;
  @AnyLogicInternalCodegenAPI
  protected static final int _seat19 = 196;
  @AnyLogicInternalCodegenAPI
  protected static final int _seat20 = 197;
  @AnyLogicInternalCodegenAPI
  protected static final int _seat21 = 198;
  @AnyLogicInternalCodegenAPI
  protected static final int _seat22 = 199;
  @AnyLogicInternalCodegenAPI
  protected static final int _seat0 = 200;
  @AnyLogicInternalCodegenAPI
  protected static final int _seat23 = 201;
  @AnyLogicInternalCodegenAPI
  protected static final int _seat1 = 202;
  @AnyLogicInternalCodegenAPI
  protected static final int _seat2 = 203;
  @AnyLogicInternalCodegenAPI
  protected static final int _seat3 = 204;
  @AnyLogicInternalCodegenAPI
  protected static final int _seat4 = 205;
  @AnyLogicInternalCodegenAPI
  protected static final int _seat5 = 206;
  @AnyLogicInternalCodegenAPI
  protected static final int _seat6 = 207;
  @AnyLogicInternalCodegenAPI
  protected static final int _workArea = 208;
  @AnyLogicInternalCodegenAPI
  protected static final int _table16 = 209;
  @AnyLogicInternalCodegenAPI
  protected static final int _table15 = 210;
  @AnyLogicInternalCodegenAPI
  protected static final int _table0 = 211;
  @AnyLogicInternalCodegenAPI
  protected static final int _table23 = 212;
  @AnyLogicInternalCodegenAPI
  protected static final int _table4 = 213;
  @AnyLogicInternalCodegenAPI
  protected static final int _table5 = 214;
  @AnyLogicInternalCodegenAPI
  protected static final int _table2 = 215;
  @AnyLogicInternalCodegenAPI
  protected static final int _table3 = 216;
  @AnyLogicInternalCodegenAPI
  protected static final int _table1 = 217;
  @AnyLogicInternalCodegenAPI
  protected static final int _table7 = 218;
  @AnyLogicInternalCodegenAPI
  protected static final int _table8 = 219;
  @AnyLogicInternalCodegenAPI
  protected static final int _table9 = 220;
  @AnyLogicInternalCodegenAPI
  protected static final int _table10 = 221;
  @AnyLogicInternalCodegenAPI
  protected static final int _table11 = 222;
  @AnyLogicInternalCodegenAPI
  protected static final int _table12 = 223;
  @AnyLogicInternalCodegenAPI
  protected static final int _table13 = 224;
  @AnyLogicInternalCodegenAPI
  protected static final int _table14 = 225;
  @AnyLogicInternalCodegenAPI
  protected static final int _table17 = 226;
  @AnyLogicInternalCodegenAPI
  protected static final int _table18 = 227;
  @AnyLogicInternalCodegenAPI
  protected static final int _table19 = 228;
  @AnyLogicInternalCodegenAPI
  protected static final int _table20 = 229;
  @AnyLogicInternalCodegenAPI
  protected static final int _table21 = 230;
  @AnyLogicInternalCodegenAPI
  protected static final int _table22 = 231;
  @AnyLogicInternalCodegenAPI
  protected static final int _area1 = 232;
  @AnyLogicInternalCodegenAPI
  protected static final int _area2 = 233;
  @AnyLogicInternalCodegenAPI
  protected static final int _area4 = 234;
  @AnyLogicInternalCodegenAPI
  protected static final int _ex2 = 235;
  @AnyLogicInternalCodegenAPI
  protected static final int _ex1 = 236;
  @AnyLogicInternalCodegenAPI
  protected static final int _office = 237;
  @AnyLogicInternalCodegenAPI
  protected static final int _s1 = 238;
  @AnyLogicInternalCodegenAPI
  protected static final int _s3_1 = 239;
  @AnyLogicInternalCodegenAPI
  protected static final int _s5 = 240;
  @AnyLogicInternalCodegenAPI
  protected static final int _s4 = 241;
  @AnyLogicInternalCodegenAPI
  protected static final int _s2 = 242;
  @AnyLogicInternalCodegenAPI
  protected static final int _s6 = 243;
  @AnyLogicInternalCodegenAPI
  protected static final int _s7 = 244;
  @AnyLogicInternalCodegenAPI
  protected static final int _s3_3 = 245;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline23 = 246;
  @AnyLogicInternalCodegenAPI
  protected static final int _s3_2 = 247;
  @AnyLogicInternalCodegenAPI
  protected static final int _area1_1 = 248;
  @AnyLogicInternalCodegenAPI
  protected static final int _area1_2 = 249;
  @AnyLogicInternalCodegenAPI
  protected static final int _office1 = 250;
  @AnyLogicInternalCodegenAPI
  protected static final int _s3_4 = 251;
  @AnyLogicInternalCodegenAPI
  protected static final int _s3_5 = 252;
  @AnyLogicInternalCodegenAPI
  protected static final int _area4_1 = 253;
  @AnyLogicInternalCodegenAPI
  protected static final int _area4_2 = 254;
  @AnyLogicInternalCodegenAPI
  protected static final int _out = 255;
  @AnyLogicInternalCodegenAPI
  protected static final int _line21 = 256;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor = 257;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor1 = 258;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor2 = 259;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor3 = 260;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor4 = 261;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor5 = 262;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor6 = 263;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor7 = 264;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor8 = 265;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor9 = 266;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor10 = 267;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor11 = 268;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor12 = 269;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor13 = 270;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor14 = 271;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor15 = 272;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor16 = 273;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor17 = 274;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor18 = 275;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor19 = 276;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor20 = 277;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor21 = 278;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor22 = 279;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor23 = 280;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor24 = 281;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor25 = 282;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor26 = 283;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor27 = 284;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor28 = 285;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor29 = 286;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor30 = 287;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor31 = 288;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor32 = 289;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor33 = 290;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor34 = 291;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor35 = 292;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor36 = 293;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor37 = 294;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor38 = 295;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor39 = 296;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor40 = 297;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor41 = 298;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor42 = 299;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor43 = 300;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor44 = 301;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor45 = 302;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor46 = 303;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor47 = 304;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor48 = 305;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor49 = 306;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor50 = 307;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor51 = 308;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor52 = 309;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor53 = 310;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor54 = 311;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor55 = 312;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor56 = 313;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor57 = 314;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor58 = 315;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor59 = 316;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor60 = 317;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor61 = 318;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor62 = 319;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor63 = 320;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor64 = 321;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor65 = 322;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor66 = 323;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor67 = 324;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor68 = 325;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor69 = 326;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor70 = 327;
  @AnyLogicInternalCodegenAPI
  protected static final int _attractor71 = 328;
  @AnyLogicInternalCodegenAPI
  protected static final int _cafeteria = 329;
  @AnyLogicInternalCodegenAPI
  protected static final int _stairwayDown = 330;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline32 = 331;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline33 = 332;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline34 = 333;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline36 = 334;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline37 = 335;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval = 336;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval1 = 337;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval10 = 338;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval11 = 339;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval2 = 340;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval3 = 341;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval4 = 342;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval5 = 343;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval6 = 344;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval7 = 345;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval8 = 346;
  @AnyLogicInternalCodegenAPI
  protected static final int _oval9 = 347;
  @AnyLogicInternalCodegenAPI
  protected static final int _window = 348;
  @AnyLogicInternalCodegenAPI
  protected static final int _coffee = 349;
  @AnyLogicInternalCodegenAPI
  protected static final int _area3 = 350;
  @AnyLogicInternalCodegenAPI
  protected static final int _area3_2 = 351;
  @AnyLogicInternalCodegenAPI
  protected static final int _area3_3 = 352;
  @AnyLogicInternalCodegenAPI
  protected static final int _area3_4 = 353;
  @AnyLogicInternalCodegenAPI
  protected static final int _tofloor1 = 354;
  @AnyLogicInternalCodegenAPI
  protected static final int _area3_5 = 355;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 356;
 

  /**
   * Top-level presentation group id
   */	 
  @AnyLogicInternalCodegenAPI
  protected static final int _presentation = 0;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return true;
  }

  @AnyLogicInternalCodegenAPI
  public boolean isEmbeddedAgentPresentationVisible( Agent _a ) {
    if (_a == evacuation) { return true; }
    return super.isEmbeddedAgentPresentationVisible( _a );
  }
  /**
   * Top-level icon group id
   */	 
  @AnyLogicInternalCodegenAPI
  protected static final int _icon = -1;
  
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline_pointsDX_xjal() {
    return new double[] { 0.0, 0.0, 519.0, 519.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline_pointsDY_xjal() {
    return new double[] { 0.0, -80.0, -80.0, 360.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline2_pointsDX_xjal() {
    return new double[] { 0.0, 50.0, 65.0, 50.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline2_pointsDY_xjal() {
    return new double[] { 0.0, 0.0, 15.0, 30.0, 30.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline2_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline3_pointsDX_xjal() {
    return new double[] { 0.0, 47.015, 61.119, 47.015, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline3_pointsDY_xjal() {
    return new double[] { 0.0, 0.0, 14.063, 28.125, 28.125,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline3_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_firstGround_xjal() {
	  firstGround.addAll(enter, line20, s8, stairwayUp, line30, servicesWC, polyline5, polyline6, polyline7, polyline8, polyline9, polyline10, polyline11, polyline12, polyline13, polyline16, table6, polyline17, polyline18, polyline20, polyline21, polyline22, polyline24, polyline25, polyline26, polyline27, polyline28, polyline29, polyline30, polyline31, polyline38, polyline39, wall, workArea, table16, table15, table0, table23, table4, table5, table2, table3, table1, table7, table8, table9, table10, table11, table12, table13, table14, table17, table18, table19, table20, table21, table22, area1, area2, area4, ex2, ex1, office, s1, s3_1, s5, s4, s2, s6, s7, s3_3, polyline23, s3_2, area1_1, area1_2, office1, s3_4, s3_5, area4_1, area4_2, out);
	  firstGround.initialize();
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_secondGround_xjal() {
	  secondGround.addAll(line21, cafeteria, stairwayDown, polyline32, polyline33, polyline34, polyline36, polyline37, oval, oval1, oval10, oval11, oval2, oval3, oval4, oval5, oval6, oval7, oval8, oval9, window, coffee, area3, area3_2, area3_3, area3_4, tofloor1, area3_5);
	  secondGround.initialize();
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _enter_pointsDX_xjal() {
    return new double[] { 0.0, 0.0,  };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] _enter_pointsDY_xjal() {
    return new double[] { 0.0, 50.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _line20_pointsDX_xjal() {
    return new double[] { 0.0, 0.0,  };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] _line20_pointsDY_xjal() {
    return new double[] { 0.0, 50.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _line30_pointsDX_xjal() {
    return new double[] { 0.0, 0.0,  };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] _line30_pointsDY_xjal() {
    return new double[] { 0.0, 40.0,  };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _queueLine_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 90.0, 280.0, 0, 90.0, 343.0, 0 ) };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline5_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 140.0, 780.0, 0.0, 10.0, 780.0, 0.0 ),
       new MarkupSegmentLine( 10.0, 780.0, 0.0, 10.0, 499.0, 0.0 ),
       new MarkupSegmentLine( 10.0, 499.0, 0.0, 10.0, 120.0, 0.0 ),
       new MarkupSegmentLine( 10.0, 120.0, 0.0, 540.0, 120.0, 0.0 ),
       new MarkupSegmentLine( 540.0, 120.0, 0.0, 540.0, 610.0, 0.0 ),
       new MarkupSegmentLine( 540.0, 610.0, 0.0, 540.0, 780.0, 0.0 ),
       new MarkupSegmentLine( 540.0, 780.0, 0.0, 140.0, 780.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline6_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 110.0, 260.0, 0.0, 110.0, 220.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline7_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 110.0, 260.0, 0.0, 110.0, 410.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline8_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 10.0, 460.0, 0.0, 113.0, 458.0, 0.0 ),
       new MarkupSegmentLine( 113.0, 458.0, 0.0, 113.0, 480.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline9_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 10.0, 540.0, 0.0, 110.0, 540.0, 0.0 ),
       new MarkupSegmentLine( 110.0, 540.0, 0.0, 110.0, 520.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline10_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 106.0, 707.5, 0.0, 106.0, 579.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline11_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 106.0, 660.0, 0.0, 120.0, 660.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline12_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 173.0, 660.0, 0.0, 193.0, 660.0, 0.0 ),
       new MarkupSegmentLine( 193.0, 660.0, 0.0, 193.0, 576.0, 0.0 ),
       new MarkupSegmentLine( 193.0, 576.0, 0.0, 290.0, 580.0, 0.0 ),
       new MarkupSegmentLine( 290.0, 580.0, 0.0, 289.0, 707.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline13_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 330.0, 580.0, 0.0, 390.0, 580.0, 0.0 ),
       new MarkupSegmentLine( 390.0, 580.0, 0.0, 390.0, 610.0, 0.0 ),
       new MarkupSegmentLine( 390.0, 610.0, 0.0, 390.01099999999997, 708.732, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline16_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 540.0, 190.0, 0.0, 310.0, 190.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline17_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 450.0, 310.0, 0.0, 450.0, 360.0, 0.0 ),
       new MarkupSegmentLine( 450.0, 360.0, 0.0, 450.0, 410.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline18_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 450.0, 360.0, 0.0, 245.0, 360.0, 0.0 ),
       new MarkupSegmentLine( 245.0, 360.0, 0.0, 250.0, 190.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline20_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 190.0, 190.0, 0.0, 190.0, 220.0, 0.0 ),
       new MarkupSegmentLine( 190.0, 220.0, 0.0, 190.0, 360.0, 0.0 ),
       new MarkupSegmentLine( 190.0, 360.0, 0.0, 190.0, 350.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline21_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 180.0, 400.0, 0.0, 174.0, 472.0, 0.0 ),
       new MarkupSegmentLine( 174.0, 472.0, 0.0, 296.0, 472.0, 0.0 ),
       new MarkupSegmentLine( 296.0, 472.0, 0.0, 296.0, 357.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline22_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 450.0, 360.0, 0.0, 450.0, 470.0, 0.0 ),
       new MarkupSegmentLine( 450.0, 470.0, 0.0, 340.0, 470.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline24_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 10.0, 260.0, 0.0, 60.0, 260.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline25_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 10.0, 220.0, 0.0, 60.0, 220.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline26_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 202.0, 576.0, 0.0, 202.0, 528.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline27_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 200.0, 487.0, 0.0, 200.0, 472.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline28_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 450.006, 190.706, 0.0, 449.0, 261.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline29_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 190.0, 190.0, 0.0, 180.0, 190.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline30_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 220.0, 360.0, 0.0, 190.0, 350.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline31_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 110.0, 200.0, 0.0, 10.0, 200.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline38_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 540.0, 710.0, 0.0, 185.0, 707.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline39_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 106.0, 700.0, 0.0, 10.0, 710.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _wall_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 419.0, 602.0, 0.0, 537.0, 602.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _workArea_pointsDX_xjal() {
    return new double[] { 0.0, 0.0, 50.0, 49.0, 297.0, 297.0, 297.0, 5.0, 10.0, 10.0, 60.0, 50.0,  };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] _workArea_pointsDY_xjal() {
    return new double[] { 0.0, 90.0, 90.0, 227.0, 227.0, 122.0, -288.0, -288.0, -230.0, -120.0, -120.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  private Attractor[] _workArea_attractors_xjal() {
    return new Attractor[] {
        seat7, seat8, seat9, seat10, seat11, seat12, seat13, seat14, seat15, seat16, seat17, 
        seat18, seat19, seat20, seat21, seat22, seat0, seat23, seat1, seat2, seat3, seat4, 
        seat5, seat6, 
    };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _area1_pointsDX_xjal() {
    return new double[] { 0.0, 10.0, 70.0, 420.0, 420.0, 70.0, 80.0,  };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] _area1_pointsDY_xjal() {
    return new double[] { 0.0, 290.0, 290.0, 290.0, 230.0, 220.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegmentLine[] _ex2_segments_xjal() {
    return new MarkupSegmentLine[] {
       new MarkupSegmentLine( 190.398, 158.478, 0, 209.602, 181.522, 0 ),
       new MarkupSegmentLine( 218.894, 135.897, 0, 229.106, 164.103, 0 ),
       new MarkupSegmentLine( 330.0, 135.897, 0, 330.0, 164.103, 0 ),
       new MarkupSegmentLine( 530.0, 135.001, 0, 530.0, 164.999, 0 ),
    };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegmentLine[] _ex1_segments_xjal() {
    return new MarkupSegmentLine[] {
       new MarkupSegmentLine( 155.0, 210.0, 0, 125.0, 210.0, 0 ),
       new MarkupSegmentLine( 161.03400660693916, 429.6714226738802, 0, 118.96599339306084, 430.3285773261198, 0 ),
       new MarkupSegmentLine( 164.831, 734.698, 0, 135.169, 765.302, 0 ),
       new MarkupSegmentLine( 520.0, 735.0, 0, 520.0, 765.0, 0 ),
    };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegmentLine[] _office_segments_xjal() {
    return new MarkupSegmentLine[] {
       new MarkupSegmentLine( 310.0, 524.143, 0, 310.0, 495.85699999999997, 0 ),
       new MarkupSegmentLine( 155.812, 525.812, 0, 124.18799999999999, 494.188, 0 ),
       new MarkupSegmentLine( 155.082, 579.061, 0, 124.918, 580.939, 0 ),
       new MarkupSegmentLine( 174.235, 724.855, 0, 145.765, 755.145, 0 ),
       new MarkupSegmentLine( 320.487, 734.392, 0, 319.513, 765.608, 0 ),
       new MarkupSegmentLine( 520.0, 734.999, 0, 520.0, 765.001, 0 ),
    };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline23_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 540.0, 600.0, 0.0, 474.006, 601.32, 0.0 ),
       new MarkupSegmentLine( 474.006, 601.32, 0.0, 440.0, 602.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegmentLine[] _office1_segments_xjal() {
    return new MarkupSegmentLine[] {
       new MarkupSegmentLine( 383.675, 282.649, 0, 396.325, 257.351, 0 ),
       new MarkupSegmentLine( 300.0, 240.0, 0, 320.0, 220.0, 0 ),
       new MarkupSegmentLine( 267.682, 163.051, 0, 292.318, 176.949, 0 ),
       new MarkupSegmentLine( 528.803, 135.043, 0, 531.197, 164.957, 0 ),
    };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegmentLine[] _out_segments_xjal() {
    return new MarkupSegmentLine[] {
       new MarkupSegmentLine( 330.0, 725.855, 0, 330.0, 754.145, 0 ),
       new MarkupSegmentLine( 530.0, 724.997, 0, 530.0, 755.003, 0 ),
    };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _line21_pointsDX_xjal() {
    return new double[] { 0.0, 0.0,  };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] _line21_pointsDY_xjal() {
    return new double[] { 0.0, 40.0,  };
  }
  @AnyLogicInternalCodegenAPI
  private Attractor[] _cafeteria_attractors_xjal() {
    return new Attractor[] {
        attractor, attractor1, attractor2, attractor3, attractor4, attractor5, attractor6, attractor7, attractor8, attractor9, attractor10, 
        attractor11, attractor12, attractor13, attractor14, attractor15, attractor16, attractor17, attractor18, attractor19, attractor20, attractor21, 
        attractor22, attractor23, attractor24, attractor25, attractor26, attractor27, attractor28, attractor29, attractor30, attractor31, attractor32, 
        attractor33, attractor34, attractor35, attractor36, attractor37, attractor38, attractor39, attractor40, attractor41, attractor42, attractor43, 
        attractor44, attractor45, attractor46, attractor47, attractor48, attractor49, attractor50, attractor51, attractor52, attractor53, attractor54, 
        attractor55, attractor56, attractor57, attractor58, attractor59, attractor60, attractor61, attractor62, attractor63, attractor64, attractor65, 
        attractor66, attractor67, attractor68, attractor69, attractor70, attractor71, 
    };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline32_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 1072.0, 562.0, 0.0, 1070.0, 580.0, 0.0 ),
       new MarkupSegmentLine( 1070.0, 580.0, 0.0, 850.0, 580.0, 0.0 ),
       new MarkupSegmentLine( 850.0, 580.0, 0.0, 550.0, 580.0, 0.0 ),
       new MarkupSegmentLine( 550.0, 580.0, 0.0, 552.0, 400.0, 0.0 ),
       new MarkupSegmentLine( 552.0, 400.0, 0.0, 552.0, 191.0, 0.0 ),
       new MarkupSegmentLine( 552.0, 191.0, 0.0, 550.0, 120.0, 0.0 ),
       new MarkupSegmentLine( 550.0, 120.0, 0.0, 820.0, 120.0, 0.0 ),
       new MarkupSegmentLine( 820.0, 120.0, 0.0, 945.0, 124.0, 0.0 ),
       new MarkupSegmentLine( 945.0, 124.0, 0.0, 1072.0, 124.0, 0.0 ),
       new MarkupSegmentLine( 1072.0, 124.0, 0.0, 1072.0, 562.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline33_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 552.0, 400.0, 0.0, 850.0, 410.0, 0.0 ),
       new MarkupSegmentLine( 850.0, 410.0, 0.0, 870.0, 510.0, 0.0 ),
       new MarkupSegmentLine( 870.0, 510.0, 0.0, 980.0, 510.0, 0.0 ),
       new MarkupSegmentLine( 980.0, 510.0, 0.0, 980.0, 560.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline34_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 551.97, 189.944, 0.0, 850.0, 190.0, 0.0 ),
       new MarkupSegmentLine( 850.0, 190.0, 0.0, 850.0, 340.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline36_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 850.0, 320.0, 0.0, 900.0, 330.0, 0.0 ),
       new MarkupSegmentLine( 900.0, 330.0, 0.0, 897.0, 218.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _polyline37_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 984.0, 200.0, 0.0, 1073.0, 200.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _window_pointsDX_xjal() {
    return new double[] { 0.0, 60.0,  };
  }

  @AnyLogicInternalCodegenAPI
  protected static final double[] _window_pointsDY_xjal() {
    return new double[] { 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegmentLine[] _tofloor1_segments_xjal() {
    return new MarkupSegmentLine[] {
       new MarkupSegmentLine( 820.0, 340.0, 0, 820.0, 380.0, 0 ),
       new MarkupSegmentLine( 955.0, 345.0, 0, 985.0, 375.0, 0 ),
       new MarkupSegmentLine( 955.0, 135.0, 0, 985.0, 165.0, 0 ),
       new MarkupSegmentLine( 1060.0, 135.0, 0, 1060.0, 165.0, 0 ),
    };
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _groupFloor1:
        if (true) {
          ShapeGroup self = this.groupFloor1;
          
 
        }
        break;
      case _groupDinnerTable:
        if (true) {
          ShapeGroup self = this.groupDinnerTable;
          
 
        }
        break;
      case _groupFloor2:
        if (true) {
          ShapeGroup self = this.groupFloor2;
          
 
        }
        break;
      case _text2:
        if (true) {
          ShapeText self = this.text2;
          
 
        }
        break;
      case _text3:
        if (true) {
          ShapeText self = this.text3;
          
 
        }
        break;
      case _rectangle1:
        if (true) {
          ShapeRectangle self = this.rectangle1;
          
 
        }
        break;
      case _polyline:
        if (true) {
          ShapePolyLine self = this.polyline;
          
 
        }
        break;
      case _line:
        if (true) {
          ShapeLine self = this.line;
          
 
        }
        break;
      case _line1:
        if (true) {
          ShapeLine self = this.line1;
          
 
        }
        break;
      case _line2:
        if (true) {
          ShapeLine self = this.line2;
          
 
        }
        break;
      case _line3:
        if (true) {
          ShapeLine self = this.line3;
          
 
        }
        break;
      case _line4:
        if (true) {
          ShapeLine self = this.line4;
          
 
        }
        break;
      case _line5:
        if (true) {
          ShapeLine self = this.line5;
          
 
        }
        break;
      case _line6:
        if (true) {
          ShapeLine self = this.line6;
          
 
        }
        break;
      case _line7:
        if (true) {
          ShapeLine self = this.line7;
          
 
        }
        break;
      case _line8:
        if (true) {
          ShapeLine self = this.line8;
          
 
        }
        break;
      case _line9:
        if (true) {
          ShapeLine self = this.line9;
          
 
        }
        break;
      case _line10:
        if (true) {
          ShapeLine self = this.line10;
          
 
        }
        break;
      case _line11:
        if (true) {
          ShapeLine self = this.line11;
          
 
        }
        break;
      case _line12:
        if (true) {
          ShapeLine self = this.line12;
          
 
        }
        break;
      case _line13:
        if (true) {
          ShapeLine self = this.line13;
          
 
        }
        break;
      case _line14:
        if (true) {
          ShapeLine self = this.line14;
          
 
        }
        break;
      case _line15:
        if (true) {
          ShapeLine self = this.line15;
          
 
        }
        break;
      case _line16:
        if (true) {
          ShapeLine self = this.line16;
          
 
        }
        break;
      case _line17:
        if (true) {
          ShapeLine self = this.line17;
          
 
        }
        break;
      case _line18:
        if (true) {
          ShapeLine self = this.line18;
          
 
        }
        break;
      case _line19:
        if (true) {
          ShapeLine self = this.line19;
          
 
        }
        break;
      case _line31:
        if (true) {
          ShapeLine self = this.line31;
          
 
        }
        break;
      case _line32:
        if (true) {
          ShapeLine self = this.line32;
          
 
        }
        break;
      case _line33:
        if (true) {
          ShapeLine self = this.line33;
          
 
        }
        break;
      case _line34:
        if (true) {
          ShapeLine self = this.line34;
          
 
        }
        break;
      case _line35:
        if (true) {
          ShapeLine self = this.line35;
          
 
        }
        break;
      case _line36:
        if (true) {
          ShapeLine self = this.line36;
          
 
        }
        break;
      case _groupSt1:
        if (true) {
          ShapeGroup self = this.groupSt1;
          
 
        }
        break;
      case _line37:
        if (true) {
          ShapeLine self = this.line37;
          
 
        }
        break;
      case _line38:
        if (true) {
          ShapeLine self = this.line38;
          
 
        }
        break;
      case _line39:
        if (true) {
          ShapeLine self = this.line39;
          
 
        }
        break;
      case _line40:
        if (true) {
          ShapeLine self = this.line40;
          
 
        }
        break;
      case _line41:
        if (true) {
          ShapeLine self = this.line41;
          
 
        }
        break;
      case _line42:
        if (true) {
          ShapeLine self = this.line42;
          
 
        }
        break;
      case _line43:
        if (true) {
          ShapeLine self = this.line43;
          
 
        }
        break;
      case _line44:
        if (true) {
          ShapeLine self = this.line44;
          
 
        }
        break;
      case _line45:
        if (true) {
          ShapeLine self = this.line45;
          
 
        }
        break;
      case _line46:
        if (true) {
          ShapeLine self = this.line46;
          
 
        }
        break;
      case _line47:
        if (true) {
          ShapeLine self = this.line47;
          
 
        }
        break;
      case _line48:
        if (true) {
          ShapeLine self = this.line48;
          
 
        }
        break;
      case _line49:
        if (true) {
          ShapeLine self = this.line49;
          
 
        }
        break;
      case _line50:
        if (true) {
          ShapeLine self = this.line50;
          
 
        }
        break;
      case _line51:
        if (true) {
          ShapeLine self = this.line51;
          
 
        }
        break;
      case _line52:
        if (true) {
          ShapeLine self = this.line52;
          
 
        }
        break;
      case _groupSt2:
        if (true) {
          ShapeGroup self = this.groupSt2;
          
 
        }
        break;
      case _rectangle2:
        if (true) {
          ShapeRectangle self = this.rectangle2;
          
 
        }
        break;
      case _rectangle9:
        if (true) {
          ShapeRectangle self = this.rectangle9;
          
 
        }
        break;
      case _line53:
        if (true) {
          ShapeLine self = this.line53;
          
 
        }
        break;
      case _textHead:
        if (true) {
          ShapeText self = this.textHead;
          
 
        }
        break;
      case _groupMainMenu:
        if (true) {
          ShapeGroup self = this.groupMainMenu;
          
 
        }
        break;
      case _text4:
        if (true) {
          ShapeText self = this.text4;
          
 
        }
        break;
      case _text5:
        if (true) {
          ShapeText self = this.text5;
          
 
        }
        break;
      case _evacuation_presentation:
        if (true) {
          ShapeEmbeddedObjectPresentation self = this.evacuation_presentation;
          
 
        }
        break;
      case _text6:
        if (true) {
          ShapeText self = this.text6;
          
 
        }
        break;
      case _text7:
        if (true) {
          ShapeText self = this.text7;
          
 
        }
        break;
      case _text9:
        if (true) {
          ShapeText self = this.text9;
          
 
        }
        break;
      case _text11:
        if (true) {
          ShapeText self = this.text11;
          
checkbox.setSelected(!checkbox.isSelected(),true); 
        }
        break;
      case _text12:
        if (true) {
          ShapeText self = this.text12;
          
 
        }
        break;
      case _text13:
        if (true) {
          ShapeText self = this.text13;
          
 
        }
        break;
      case _line72:
        if (true) {
          ShapeLine self = this.line72;
          
 
        }
        break;
      case _text14:
        if (true) {
          ShapeText self = this.text14;
          
 
        }
        break;
      case _line73:
        if (true) {
          ShapeLine self = this.line73;
          
 
        }
        break;
      case _text15:
        if (true) {
          ShapeText self = this.text15;
          
 
        }
        break;
      case _line85:
        if (true) {
          ShapeLine self = this.line85;
          
 
        }
        break;
      case _line86:
        if (true) {
          ShapeLine self = this.line86;
          
 
        }
        break;
      case _text16:
        if (true) {
          ShapeText self = this.text16;
          
 
        }
        break;
      case _line87:
        if (true) {
          ShapeLine self = this.line87;
          
 
        }
        break;
      case _text17:
        if (true) {
          ShapeText self = this.text17;
          
 
        }
        break;
      case _text8:
        if (true) {
          ShapeText self = this.text8;
          
 
        }
        break;
      case _polyline2:
        if (true) {
          ShapePolyLine self = this.polyline2;
          
 
        }
        break;
      case _text10:
        if (true) {
          ShapeText self = this.text10;
          
 
        }
        break;
      case _group2:
        if (true) {
          ShapeGroup self = this.group2;
          
 
        }
        break;
      case _text20:
        if (true) {
          ShapeText self = this.text20;
          
 
        }
        break;
      case _text21:
        if (true) {
          ShapeText self = this.text21;
          
 
        }
        break;
      case _text18:
        if (true) {
          ShapeText self = this.text18;
          
 
        }
        break;
      case _text22:
        if (true) {
          ShapeText self = this.text22;
          
 
        }
        break;
      case _text23:
        if (true) {
          ShapeText self = this.text23;
          
 
        }
        break;
      case _text24:
        if (true) {
          ShapeText self = this.text24;
          
 
        }
        break;
      case _line22:
        if (true) {
          ShapeLine self = this.line22;
          
 
        }
        break;
      case _text25:
        if (true) {
          ShapeText self = this.text25;
          
 
        }
        break;
      case _line23:
        if (true) {
          ShapeLine self = this.line23;
          
 
        }
        break;
      case _text26:
        if (true) {
          ShapeText self = this.text26;
          
 
        }
        break;
      case _text27:
        if (true) {
          ShapeText self = this.text27;
          
 
        }
        break;
      case _text28:
        if (true) {
          ShapeText self = this.text28;
          
 
        }
        break;
      case _text29:
        if (true) {
          ShapeText self = this.text29;
          
 
        }
        break;
      case _text30:
        if (true) {
          ShapeText self = this.text30;
          
 
        }
        break;
      case _myAgent_presentation:
        if (true) {
          ShapeEmbeddedObjectPresentation self = this.myAgent_presentation.get( index );
          
 
        }
        break;
      case _text31:
        if (true) {
          ShapeText self = this.text31;
          
 
        }
        break;
      case _text32:
        if (true) {
          ShapeText self = this.text32;
          
 
        }
        break;
      case _visitor_presentation:
        if (true) {
          ShapeEmbeddedObjectPresentation self = this.visitor_presentation.get( index );
          
 
        }
        break;
      case _text33:
        if (true) {
          ShapeText self = this.text33;
          
 
        }
        break;
      case _text34:
        if (true) {
          ShapeText self = this.text34;
          
 
        }
        break;
      case _text35:
        if (true) {
          ShapeText self = this.text35;
          
 
        }
        break;
      case _text38:
        if (true) {
          ShapeText self = this.text38;
          
 
        }
        break;
      case _text39:
        if (true) {
          ShapeText self = this.text39;
          
 
        }
        break;
      case _text36:
        if (true) {
          ShapeText self = this.text36;
          
 
        }
        break;
      case _text40:
        if (true) {
          ShapeText self = this.text40;
          
 
        }
        break;
      case _text41:
        if (true) {
          ShapeText self = this.text41;
          
 
        }
        break;
      case _text37:
        if (true) {
          ShapeText self = this.text37;
          
 
        }
        break;
      case _text42:
        if (true) {
          ShapeText self = this.text42;
          
 
        }
        break;
      case _text44:
        if (true) {
          ShapeText self = this.text44;
          
 
        }
        break;
      case _rectangle3:
        if (true) {
          ShapeRectangle self = this.rectangle3;
          
 
        }
        break;
      case _text:
        if (true) {
          ShapeText self = this.text;
          
 
        }
        break;
      case _text1:
        if (true) {
          ShapeText self = this.text1;
          
 
        }
        break;
      case _text45:
        if (true) {
          ShapeText self = this.text45;
          
 
        }
        break;
      case _oval12:
        if (true) {
          ShapeOval self = this.oval12;
          
 
        }
        break;
      case _oval13:
        if (true) {
          ShapeOval self = this.oval13;
          
 
        }
        break;
      case _text46:
        if (true) {
          ShapeText self = this.text46;
          
 
        }
        break;
      case _polyline3:
        if (true) {
          ShapePolyLine self = this.polyline3;
          
 
        }
        break;
      case _text43:
        if (true) {
          ShapeText self = this.text43;
          
 
        }
        break;
      case _group4:
        if (true) {
          ShapeGroup self = this.group4;
          
 
        }
        break;
      case _text47:
        if (true) {
          ShapeText self = this.text47;
          
 
        }
        break;
      case _success:
        if (true) {
          ShapeText self = this.success;
          
 
        }
        break;
      case _text48:
        if (true) {
          ShapeText self = this.text48;
          
 
        }
        break;
      case _text49:
        if (true) {
          ShapeText self = this.text49;
          
 
        }
        break;
      case _oval14:
        if (true) {
          ShapeOval self = this.oval14;
          
 
        }
        break;
      case _text50:
        if (true) {
          ShapeText self = this.text50;
          
 
        }
        break;
      case _text51:
        if (true) {
          ShapeText self = this.text51;
          
 
        }
        break;
      case _text52:
        if (true) {
          ShapeText self = this.text52;
          
 
        }
        break;
      case _text53:
        if (true) {
          ShapeText self = this.text53;
          
 
        }
        break;
      case _text54:
        if (true) {
          ShapeText self = this.text54;
          
 
        }
        break;
      case _text55:
        if (true) {
          ShapeText self = this.text55;
          
 
        }
        break;
      case _text56:
        if (true) {
          ShapeText self = this.text56;
          
 
        }
        break;
      case _helper_success:
        if (true) {
          ShapeText self = this.helper_success;
          
 
        }
        break;
      default: return super.onShapeClick( _shape, index, clickx, clicky );
 	}
 	return false;
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public void onShapeGroupDraw( int _shape, int index, Panel panel, Graphics2D graphics ) {
    switch( _shape ) {
      case _groupFloor1:
          
 
        break;
      case _groupDinnerTable:
          
 
        break;
      case _groupFloor2:
          
 
        break;
      case _groupSt1:
          
 
        break;
      case _groupSt2:
          
 
        break;
      case _groupMainMenu:
          
 
        break;
      case _group2:
          
 
        break;
      case _group4:
          
 
        break;
      default:
        super.onShapeGroupDraw( _shape, index, panel, graphics );
        break;
    }
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index ) {
    switch( _shape ) {
      case _button: {
          ShapeButton self = this.button;
getEngine().setRealTimeMode(true);
getEngine().setRealTimeScale(1);
alarm = true;
if(enter.getColor()==red)
evacuation.exits.remove(enter);
if(line30.getColor()==red)
evacuation.exits.remove(line30);
alarmBegining = time();
//checkbox.setEnabled(false);
pedGoToCafeteria.cancelAll();
pedGoToWork.cancelAll();
pedGoToStairs.cancelAll();
pedGoToExit.cancelAll();
pedGoToTable.cancelAll();
pedWork.cancelAll();
pedWC.cancelAll();
pedEat.cancelAll();
pedSmoke.cancelAll();

visitorSource.set_limitArrivals(true);
visitorSource.set_maxArrivals(visitorSource.countPeds());

//workerSource.set_rate(0);
evacuationStart.add(time(),0);
evacuationStart.add(time(),getPeopleInsideCount()); 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index );
        break;
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, boolean value ) {
    switch( _shape ) {
      case _checkbox:
        set_addExit( value ); {
          ShapeCheckBox self = this.checkbox;
//if (value)evacuation.exits.add(line30);
//else evacuation.exits.remove(line30); 
;}
        break;
      case _checkbox1:
        set_active_dynamic( value ); {
          ShapeCheckBox self = this.checkbox1;
//if (value)evacuation.exits.add(enter);
//else evacuation.exits.remove(enter); 
;}
        break;
      case _checkbox2:
        set_active_predict_help( value ); {
          ShapeCheckBox self = this.checkbox2;
if(active_predict_help==true){
dynamic_help =true;
 active_dynamic=true;
}
else{
dynamic_help =false;
 active_dynamic=false;
}
//if (value)evacuation.exits.add(enter);
//else evacuation.exits.remove(enter); 
;}
        break;
      case _checkbox4:
        set_dynamic_help( value ); {
          ShapeCheckBox self = this.checkbox4;
if(dynamic_help==true)
active_dynamic=true;
else
active_dynamic=false;
//if (value)evacuation.exits.add(enter);
//else evacuation.exits.remove(enter); 
;}
        break;
      case _checkbox5:
        set_active_safest( value ); {
          ShapeCheckBox self = this.checkbox5;
//if (value)evacuation.exits.add(enter);
//else evacuation.exits.remove(enter); 
;}
        break;
      case _checkbox6:
        set_static_withdoor_sensor( value ); {
          ShapeCheckBox self = this.checkbox6;
//if (value)evacuation.exits.add(enter);
//else evacuation.exits.remove(enter); 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index, value );
        break;
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, int value ) {
    switch( _shape ) {
      case _radioLayoutType: {
          ShapeRadioButtonGroup self = this.radioLayoutType;
setLayoutType( LayoutType.values()[value] );
applyLayout();
 
;}
        break;
      case _radioNetworkType: {
          ShapeRadioButtonGroup self = this.radioNetworkType;
refreshNetwork(); 
;}
        break;
      case _radio: {
          ShapeRadioButtonGroup self = this.radio;
switch( value ) {
case 0: setNumberOfAgents( 10 ); break;
case 1: setNumberOfAgents( 50 ); break;
case 2: setNumberOfAgents( 100 ); break;
case 3: setNumberOfAgents( 200 ); break;
case 4: setNumberOfAgents( 500 ); break;
} 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index, value );
        break;
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, double value ) {
    switch( _shape ) {
      case _sliderRange:
        connectionRange = value; {
          ShapeSlider self = this.sliderRange;
refreshNetwork(); 
;}
        break;
      case _sliderConnectionsPerAgent:
        connectionsPerAgent = value; {
          ShapeSlider self = this.sliderConnectionsPerAgent;
refreshNetwork(); 
;}
        break;
      case _sliderNeighborLinkProb:
        neighborLinkProbability = value; {
          ShapeSlider self = this.sliderNeighborLinkProb;
refreshNetwork(); 
;}
        break;
      case _sliderScaleFreeM:
        scaleFreeM = (int) value; {
          ShapeSlider self = this.sliderScaleFreeM;
refreshNetwork(); 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index, value );
        break;
    }
  }
         
  @Override
  @AnyLogicInternalCodegenAPI
  public void onSelectionChanged_xjal( int _shape, int index, int[] selectedIndices, boolean programmatically ) {
    switch( _shape ) {
      case _plot: {
        TimePlot self = this.plot;
        
 
;}
        break;
      default:
        super.onSelectionChanged_xjal( _shape, index, selectedIndices, programmatically );
        break;
    }
  }

 
  @Override
  @AnyLogicInternalCodegenAPI
  public void onItemRemoved_xjal( int _shape, int index, int removedIndex, boolean programmatically ) {
    switch( _shape ) {
      case _plot: {
        TimePlot self = this.plot;
        
 
;}
        break;
      default:
        super.onItemRemoved_xjal( _shape, index, removedIndex, programmatically );
        break;
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getShapeControlMinimum( int _shape, int index ) {
    switch( _shape ) {
      case _sliderRange: return 
0 
;
      case _sliderConnectionsPerAgent: return 
0 
;
      case _sliderNeighborLinkProb: return 
0 
;
      case _sliderScaleFreeM: return 
0 
;
      default: return super.getShapeControlMinimum( _shape, index );
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getShapeControlMaximum( int _shape, int index ) {
    switch( _shape ) {
      case _sliderRange: return 
500 
;
      case _sliderConnectionsPerAgent: return 
10 
;
      case _sliderNeighborLinkProb: return 
1 
;
      case _sliderScaleFreeM: return 
50 
;
      default: return super.getShapeControlMaximum( _shape, index );
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean getShapeControlDefaultValueBoolean( int _shape, int index ) {
    switch(_shape) {
      case _checkbox: return 
addExit 
;
      case _checkbox1: return 
active_dynamic 
;
      case _checkbox2: return 
active_predict_help 
;
      case _checkbox4: return 
dynamic_help 
;
      case _checkbox5: return 
active_safest 
;
      case _checkbox6: return 
static_withdoor_sensor 
;
      default: return super.getShapeControlDefaultValueBoolean( _shape, index );
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public int getShapeControlDefaultValueInt( int _shape, int index ) {
    switch(_shape) {
      case _radioLayoutType: return 
2 
;
      case _radioNetworkType: return 
0 
;
      case _radio: return 
1 
;
      default: return super.getShapeControlDefaultValueInt( _shape, index );
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getShapeControlDefaultValueDouble( int _shape, int index ) {
    switch(_shape) {
      case _sliderRange: return 
connectionRange 
;
      case _sliderConnectionsPerAgent: return 
connectionsPerAgent 
;
      case _sliderNeighborLinkProb: return 
neighborLinkProbability 
;
      case _sliderScaleFreeM: return 
scaleFreeM 
;
      default: return super.getShapeControlDefaultValueDouble( _shape, index );
    }
  }
  
  // Stub function for code completion support (internal)
  @AnyLogicInternalCodegenAPI
  private void _stubForReplication_xjal() {
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
  }

  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _checkbox_SetDynamicParams_xjal( ShapeCheckBox shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setEnabled(
 
);
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setFillColor(
 
);
    shape.setTextColor(
 
);
    shape.setFont(
 
);
    shape.setText(
 
);
 	}
  }
  
  protected ShapeCheckBox checkbox;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _button_SetDynamicParams_xjal( ShapeButton shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setEnabled(
!alarm 
);
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setFillColor(
 
);
    shape.setTextColor(
 
);
    shape.setFont(
 
);
    shape.setText(
 
);
 	}
  }
  
  protected ShapeButton button;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sliderRange_SetDynamicParams_xjal( ShapeSlider shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setEnabled(
radioNetworkType.getValue() == 2 
);
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setFillColor(
 
);
    shape.setRange( getShapeControlMinimum( _sliderRange ), getShapeControlMaximum( _sliderRange ) );
 	}
  }
  
  protected ShapeSlider sliderRange;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _radioLayoutType_SetDynamicParams_xjal( ShapeRadioButtonGroup shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setEnabled(
 
);
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setFillColor(
 
);
    shape.setTextColor(
 
);
    shape.setFont(
 
);
 	}
  }
  
  protected ShapeRadioButtonGroup radioLayoutType;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _radioNetworkType_SetDynamicParams_xjal( ShapeRadioButtonGroup shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setEnabled(
 
);
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setFillColor(
 
);
    shape.setTextColor(
 
);
    shape.setFont(
 
);
 	}
  }
  
  protected ShapeRadioButtonGroup radioNetworkType;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sliderConnectionsPerAgent_SetDynamicParams_xjal( ShapeSlider shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setEnabled(
radioNetworkType.getValue() == 1 || radioNetworkType.getValue() == 3 || radioNetworkType.getValue() == 4 
);
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setFillColor(
 
);
    shape.setRange( getShapeControlMinimum( _sliderConnectionsPerAgent ), getShapeControlMaximum( _sliderConnectionsPerAgent ) );
 	}
  }
  
  protected ShapeSlider sliderConnectionsPerAgent;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sliderNeighborLinkProb_SetDynamicParams_xjal( ShapeSlider shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setEnabled(
radioNetworkType.getValue() == 4 
);
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setFillColor(
 
);
    shape.setRange( getShapeControlMinimum( _sliderNeighborLinkProb ), getShapeControlMaximum( _sliderNeighborLinkProb ) );
 	}
  }
  
  protected ShapeSlider sliderNeighborLinkProb;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _sliderScaleFreeM_SetDynamicParams_xjal( ShapeSlider shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setEnabled(
radioNetworkType.getValue() == 5 
);
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setFillColor(
 
);
    shape.setRange( getShapeControlMinimum( _sliderScaleFreeM ), getShapeControlMaximum( _sliderScaleFreeM ) );
 	}
  }
  
  protected ShapeSlider sliderScaleFreeM;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _radio_SetDynamicParams_xjal( ShapeRadioButtonGroup shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setEnabled(
 
);
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setFillColor(
 
);
    shape.setTextColor(
 
);
    shape.setFont(
 
);
 	}
  }
  
  protected ShapeRadioButtonGroup radio;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _checkbox1_SetDynamicParams_xjal( ShapeCheckBox shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setEnabled(
 
);
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setFillColor(
 
);
    shape.setTextColor(
 
);
    shape.setFont(
 
);
    shape.setText(
 
);
 	}
  }
  
  protected ShapeCheckBox checkbox1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _checkbox2_SetDynamicParams_xjal( ShapeCheckBox shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setEnabled(
 
);
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setFillColor(
 
);
    shape.setTextColor(
 
);
    shape.setFont(
 
);
    shape.setText(
 
);
 	}
  }
  
  protected ShapeCheckBox checkbox2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _checkbox4_SetDynamicParams_xjal( ShapeCheckBox shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setEnabled(
 
);
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setFillColor(
 
);
    shape.setTextColor(
 
);
    shape.setFont(
 
);
    shape.setText(
 
);
 	}
  }
  
  protected ShapeCheckBox checkbox4;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _checkbox5_SetDynamicParams_xjal( ShapeCheckBox shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setEnabled(
 
);
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setFillColor(
 
);
    shape.setTextColor(
 
);
    shape.setFont(
 
);
    shape.setText(
 
);
 	}
  }
  
  protected ShapeCheckBox checkbox5;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _checkbox6_SetDynamicParams_xjal( ShapeCheckBox shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setEnabled(
 
);
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setFillColor(
 
);
    shape.setTextColor(
 
);
    shape.setFont(
 
);
    shape.setText(
 
);
 	}
  }
  
  protected ShapeCheckBox checkbox6;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _plot_SetDynamicParams_xjal( TimePlot shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
 	}
  }
  
  protected TimePlot plot;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _groupFloor1_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotationY(
 
);
    shape.setRotationX(
 
);
    shape.setRotationZ(
 
);
 	}
  }
  
  protected ShapeGroup groupFloor1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _groupDinnerTable_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotationY(
 
);
    shape.setRotationX(
 
);
    shape.setRotationZ(
 
);
 	}
  }
  
  protected ShapeGroup groupDinnerTable;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _groupFloor2_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotationY(
 
);
    shape.setRotationX(
 
);
    shape.setRotationZ(
 
);
 	}
  }
  
  protected ShapeGroup groupFloor2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text2_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
alarm ? (((int) getEvacuationTime())/60 + ":" +(((int)getEvacuationTime())%60 < 10 ? "0" : "") + ((int)(alarmEnding == 0 ? (time() - alarmBegining)/second() : (alarmEnding - alarmBegining)/second()))%60) : "00:00" 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text3_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle1_SetDynamicParams_xjal( ShapeRectangle shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeRectangle rectangle1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline_SetDynamicParams_xjal( ShapePolyLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
    shape.setNPoints(
 
);
    for (int indexPt = 0; indexPt < shape.getNPoints(); indexPt++) {
      shape.setPointDx( indexPt, 
 
);
     }
    for (int indexPt = 0; indexPt < shape.getNPoints(); indexPt++) {
      shape.setPointDy( indexPt, 
 
);
    }
    for (int indexPt = 0; indexPt < shape.getNPoints(); indexPt++) {
      shape.setPointDz( indexPt, 
 
);
    }
 	}
  }
  
  protected ShapePolyLine polyline;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line1_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line2_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line3_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line4_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line4;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line5_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line5;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line6_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line6;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line7_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line7;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line8_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line8;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line9_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line9;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line10_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line10;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line11_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line11;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line12_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line12;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line13_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line13;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line14_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line14;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line15_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line15;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line16_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line16;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line17_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line17;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line18_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line18;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line19_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line19;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line31_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line31;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line32_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line32;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line33_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line33;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line34_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line34;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line35_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line35;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line36_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line36;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _groupSt1_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotationY(
 
);
    shape.setRotationX(
 
);
    shape.setRotationZ(
 
);
 	}
  }
  
  protected ShapeGroup groupSt1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line37_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line37;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line38_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line38;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line39_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line39;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line40_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line40;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line41_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line41;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line42_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line42;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line43_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line43;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line44_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line44;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line45_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line45;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line46_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line46;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line47_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line47;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line48_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line48;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line49_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line49;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line50_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line50;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line51_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line51;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line52_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line52;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _groupSt2_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotationY(
 
);
    shape.setRotationX(
 
);
    shape.setRotationZ(
 
);
 	}
  }
  
  protected ShapeGroup groupSt2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle2_SetDynamicParams_xjal( ShapeRectangle shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeRectangle rectangle2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle9_SetDynamicParams_xjal( ShapeRectangle shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeRectangle rectangle9;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line53_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line53;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _textHead_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText textHead;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _groupMainMenu_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotationY(
 
);
    shape.setRotationX(
 
);
    shape.setRotationZ(
 
);
 	}
  }
  
  protected ShapeGroup groupMainMenu;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text4_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text4;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text5_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text5;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _evacuation_presentation_SetDynamicParams_xjal( ShapeEmbeddedObjectPresentation shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setRotation(
 
);
 	}
  }
  
  protected ShapeEmbeddedObjectPresentation evacuation_presentation;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text6_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text6;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text7_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text7;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text9_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text9;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text11_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text11;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text12_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
"Cafeteria" + (cafeteriaOpen ? "" : " (closed)") 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text12;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text13_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text13;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line72_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line72;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text14_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text14;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line73_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line73;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text15_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text15;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line85_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line85;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line86_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line86;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text16_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text16;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line87_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line87;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text17_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text17;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text8_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text8;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline2_SetDynamicParams_xjal( ShapePolyLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
    shape.setNPoints(
 
);
    for (int indexPt = 0; indexPt < shape.getNPoints(); indexPt++) {
      shape.setPointDx( indexPt, 
 
);
     }
    for (int indexPt = 0; indexPt < shape.getNPoints(); indexPt++) {
      shape.setPointDy( indexPt, 
 
);
    }
    for (int indexPt = 0; indexPt < shape.getNPoints(); indexPt++) {
      shape.setPointDz( indexPt, 
 
);
    }
 	}
  }
  
  protected ShapePolyLine polyline2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text10_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text10;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _group2_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
alarm 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotationY(
 
);
    shape.setRotationX(
 
);
    shape.setRotationZ(
 
);
 	}
  }
  
  protected ShapeGroup group2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text20_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text20;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text21_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
timeToString(time()) 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text21;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text18_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text18;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text22_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text22;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text23_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text23;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text24_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text24;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line22_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line22;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text25_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text25;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line23_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line23;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text26_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text26;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text27_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
format( connectionsPerAgent ) 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text27;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text28_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
format( connectionRange ) 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text28;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text29_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
format( scaleFreeM ) 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text29;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text30_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
format( neighborLinkProbability ) 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text30;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _myAgent_presentation_SetDynamicParams_xjal( ShapeEmbeddedObjectPresentation shape, int index ) {
    boolean _visible = _myAgent_presentation_Visible();
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setRotation(
 
);
 	}
  }
  
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private boolean _myAgent_presentation_Visible() {
    return 
 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  protected ShapeEmbeddedObjectPresentation _myAgent_presentation_createShapeWithStaticProperties_xjal( final Agent _a, final int _index ) {
    ShapeEmbeddedObjectPresentation shape = new ShapeEmbeddedObjectPresentation( Main.this, SHAPE_DRAW_2D, true, 40.0, 150.0, 0.0, 0.0,
		true, true, _a );

    return shape;
  }

  protected ShapeAgentPopulationGroup myAgent_presentation;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text31_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text31;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text32_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
dead 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text32;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _visitor_presentation_SetDynamicParams_xjal( ShapeEmbeddedObjectPresentation shape, int index ) {
    boolean _visible = _visitor_presentation_Visible();
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setRotation(
 
);
 	}
  }
  
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private boolean _visitor_presentation_Visible() {
    return 
 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  protected ShapeEmbeddedObjectPresentation _visitor_presentation_createShapeWithStaticProperties_xjal( final Agent _a, final int _index ) {
    ShapeEmbeddedObjectPresentation shape = new ShapeEmbeddedObjectPresentation( Main.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, _a );

    return shape;
  }

  protected ShapeAgentPopulationGroup visitor_presentation;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text33_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text33;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text34_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
//evacuation.pedSink.in.count()
evacuation.pedSink.in.count()-evacuation.people_helper 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text34;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text35_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text35;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text38_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text38;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text39_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
evacuation.pedShortWait.out.count()-evacuation.people_helper+ evacuation.helper_canceled
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text39;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text36_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text36;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text40_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
evacuation.helpsource.out.count() 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text40;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text41_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text41;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text37_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text37;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text42_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
evacuation.people_helped 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text42;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text44_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text44;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle3_SetDynamicParams_xjal( ShapeRectangle shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeRectangle rectangle3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
getPeopleInsideCount() 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text1_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text45_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text45;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval12_SetDynamicParams_xjal( ShapeOval shape ) {
    boolean _visible = 
alarm
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setRotation(
 
);
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setRadius(
toPixels(11.5, METER) 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeOval oval12;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval13_SetDynamicParams_xjal( ShapeOval shape ) {
    boolean _visible = 
//alarm
false 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setRotation(
 
);
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setRadius(
toPixels(radius2, METER) 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeOval oval13;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text46_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text46;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline3_SetDynamicParams_xjal( ShapePolyLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
    shape.setNPoints(
 
);
    for (int indexPt = 0; indexPt < shape.getNPoints(); indexPt++) {
      shape.setPointDx( indexPt, 
 
);
     }
    for (int indexPt = 0; indexPt < shape.getNPoints(); indexPt++) {
      shape.setPointDy( indexPt, 
 
);
    }
    for (int indexPt = 0; indexPt < shape.getNPoints(); indexPt++) {
      shape.setPointDz( indexPt, 
 
);
    }
 	}
  }
  
  protected ShapePolyLine polyline3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text43_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text43;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _group4_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
alarm 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotationY(
 
);
    shape.setRotationX(
 
);
    shape.setRotationZ(
 
);
 	}
  }
  
  protected ShapeGroup group4;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text47_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text47;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _success_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
alarm 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
//all survived except helpers / all people inside
getsuccess_rate()*100 
//5.5 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText success;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text48_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
evacuation.pedLongWait.in.count() 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text48;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text49_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text49;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval14_SetDynamicParams_xjal( ShapeOval shape ) {
    boolean _visible = 
alarm
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setRotation(
 
);
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setRadius(
toPixels(7.5, METER) 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeOval oval14;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text50_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
injured 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text50;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text51_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text51;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text52_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text52;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text53_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
evacuation.injured_people_helped 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text53;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text54_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
evacuation.pedLongWait.in.count()-dead 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text54;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text55_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text55;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text56_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text56;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _helper_success_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
alarm 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
//all survived except helpers / all people inside
((double)evacuation.people_helped / (double)evacuation.inside_alive )*100 
//5.5 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText helper_success;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _enter_SetDynamicParams_xjal( TargetLine shape ) {
    shape.setColor(
 
);
  }
  
  protected TargetLine enter;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line20_SetDynamicParams_xjal( TargetLine shape ) {
    shape.setColor(
 
);
  }
  
  protected TargetLine line20;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _s8_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode s8;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _stairwayUp_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode stairwayUp;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line30_SetDynamicParams_xjal( TargetLine shape ) {
    shape.setColor(
 
);
  }
  
  protected TargetLine line30;
  protected QueuePath queueLine;
  protected ServicePoint<QueuePath> servicePoint;
  protected ServicePoint<QueuePath> servicePoint3;
  protected ServicePoint<QueuePath> servicePoint4;
  protected ServicePoint<QueuePath> servicePoint5;
  protected ServiceWLine<ServicePoint<QueuePath>> servicesWC;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline5_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline5;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline6_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline6;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline7_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline7;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline8_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline8;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline9_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline9;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline10_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline10;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline11_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline11;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline12_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline12;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline13_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline13;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline16_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline16;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _table6_SetDynamicParams_xjal( RectangularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected RectangularWall table6;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline17_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline17;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline18_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline18;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline20_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline20;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline21_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline21;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline22_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline22;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline24_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline24;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline25_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline25;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline26_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline26;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline27_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline27;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline28_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline28;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline29_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline29;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline30_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline30;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline31_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline31;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline38_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline38;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline39_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline39;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _wall_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall wall;
  protected Attractor seat7;
  protected Attractor seat8;
  protected Attractor seat9;
  protected Attractor seat10;
  protected Attractor seat11;
  protected Attractor seat12;
  protected Attractor seat13;
  protected Attractor seat14;
  protected Attractor seat15;
  protected Attractor seat16;
  protected Attractor seat17;
  protected Attractor seat18;
  protected Attractor seat19;
  protected Attractor seat20;
  protected Attractor seat21;
  protected Attractor seat22;
  protected Attractor seat0;
  protected Attractor seat23;
  protected Attractor seat1;
  protected Attractor seat2;
  protected Attractor seat3;
  protected Attractor seat4;
  protected Attractor seat5;
  protected Attractor seat6;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _workArea_SetDynamicParams_xjal( PolygonalNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected PolygonalNode workArea;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _table16_SetDynamicParams_xjal( RectangularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected RectangularWall table16;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _table15_SetDynamicParams_xjal( RectangularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected RectangularWall table15;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _table0_SetDynamicParams_xjal( RectangularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected RectangularWall table0;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _table23_SetDynamicParams_xjal( RectangularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected RectangularWall table23;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _table4_SetDynamicParams_xjal( RectangularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected RectangularWall table4;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _table5_SetDynamicParams_xjal( RectangularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected RectangularWall table5;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _table2_SetDynamicParams_xjal( RectangularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected RectangularWall table2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _table3_SetDynamicParams_xjal( RectangularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected RectangularWall table3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _table1_SetDynamicParams_xjal( RectangularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected RectangularWall table1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _table7_SetDynamicParams_xjal( RectangularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected RectangularWall table7;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _table8_SetDynamicParams_xjal( RectangularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected RectangularWall table8;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _table9_SetDynamicParams_xjal( RectangularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected RectangularWall table9;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _table10_SetDynamicParams_xjal( RectangularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected RectangularWall table10;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _table11_SetDynamicParams_xjal( RectangularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected RectangularWall table11;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _table12_SetDynamicParams_xjal( RectangularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected RectangularWall table12;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _table13_SetDynamicParams_xjal( RectangularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected RectangularWall table13;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _table14_SetDynamicParams_xjal( RectangularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected RectangularWall table14;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _table17_SetDynamicParams_xjal( RectangularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected RectangularWall table17;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _table18_SetDynamicParams_xjal( RectangularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected RectangularWall table18;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _table19_SetDynamicParams_xjal( RectangularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected RectangularWall table19;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _table20_SetDynamicParams_xjal( RectangularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected RectangularWall table20;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _table21_SetDynamicParams_xjal( RectangularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected RectangularWall table21;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _table22_SetDynamicParams_xjal( RectangularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected RectangularWall table22;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _area1_SetDynamicParams_xjal( PolygonalNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected PolygonalNode area1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _area2_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode area2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _area4_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode area4;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _ex2_SetDynamicParams_xjal( Pathway shape ) {
    shape.setLineColor(
 
);
  }
  
  protected Pathway ex2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _ex1_SetDynamicParams_xjal( Pathway shape ) {
    shape.setLineColor(
 
);
  }
  
  protected Pathway ex1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _office_SetDynamicParams_xjal( Pathway shape ) {
    shape.setLineColor(
 
);
  }
  
  protected Pathway office;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _s1_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode s1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _s3_1_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode s3_1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _s5_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode s5;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _s4_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode s4;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _s2_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode s2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _s6_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode s6;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _s7_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode s7;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _s3_3_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode s3_3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline23_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline23;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _s3_2_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode s3_2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _area1_1_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode area1_1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _area1_2_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode area1_2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _office1_SetDynamicParams_xjal( Pathway shape ) {
    shape.setLineColor(
 
);
  }
  
  protected Pathway office1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _s3_4_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode s3_4;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _s3_5_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode s3_5;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _area4_1_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode area4_1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _area4_2_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode area4_2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _out_SetDynamicParams_xjal( Pathway shape ) {
    shape.setLineColor(
 
);
  }
  
  protected Pathway out;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line21_SetDynamicParams_xjal( TargetLine shape ) {
    shape.setColor(
 
);
  }
  
  protected TargetLine line21;
  protected Attractor attractor;
  protected Attractor attractor1;
  protected Attractor attractor2;
  protected Attractor attractor3;
  protected Attractor attractor4;
  protected Attractor attractor5;
  protected Attractor attractor6;
  protected Attractor attractor7;
  protected Attractor attractor8;
  protected Attractor attractor9;
  protected Attractor attractor10;
  protected Attractor attractor11;
  protected Attractor attractor12;
  protected Attractor attractor13;
  protected Attractor attractor14;
  protected Attractor attractor15;
  protected Attractor attractor16;
  protected Attractor attractor17;
  protected Attractor attractor18;
  protected Attractor attractor19;
  protected Attractor attractor20;
  protected Attractor attractor21;
  protected Attractor attractor22;
  protected Attractor attractor23;
  protected Attractor attractor24;
  protected Attractor attractor25;
  protected Attractor attractor26;
  protected Attractor attractor27;
  protected Attractor attractor28;
  protected Attractor attractor29;
  protected Attractor attractor30;
  protected Attractor attractor31;
  protected Attractor attractor32;
  protected Attractor attractor33;
  protected Attractor attractor34;
  protected Attractor attractor35;
  protected Attractor attractor36;
  protected Attractor attractor37;
  protected Attractor attractor38;
  protected Attractor attractor39;
  protected Attractor attractor40;
  protected Attractor attractor41;
  protected Attractor attractor42;
  protected Attractor attractor43;
  protected Attractor attractor44;
  protected Attractor attractor45;
  protected Attractor attractor46;
  protected Attractor attractor47;
  protected Attractor attractor48;
  protected Attractor attractor49;
  protected Attractor attractor50;
  protected Attractor attractor51;
  protected Attractor attractor52;
  protected Attractor attractor53;
  protected Attractor attractor54;
  protected Attractor attractor55;
  protected Attractor attractor56;
  protected Attractor attractor57;
  protected Attractor attractor58;
  protected Attractor attractor59;
  protected Attractor attractor60;
  protected Attractor attractor61;
  protected Attractor attractor62;
  protected Attractor attractor63;
  protected Attractor attractor64;
  protected Attractor attractor65;
  protected Attractor attractor66;
  protected Attractor attractor67;
  protected Attractor attractor68;
  protected Attractor attractor69;
  protected Attractor attractor70;
  protected Attractor attractor71;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _cafeteria_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode cafeteria;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _stairwayDown_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode stairwayDown;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline32_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline32;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline33_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline33;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline34_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline34;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline36_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline36;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline37_SetDynamicParams_xjal( Wall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected Wall polyline37;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval_SetDynamicParams_xjal( CircularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected CircularWall oval;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval1_SetDynamicParams_xjal( CircularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected CircularWall oval1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval10_SetDynamicParams_xjal( CircularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected CircularWall oval10;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval11_SetDynamicParams_xjal( CircularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected CircularWall oval11;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval2_SetDynamicParams_xjal( CircularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected CircularWall oval2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval3_SetDynamicParams_xjal( CircularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected CircularWall oval3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval4_SetDynamicParams_xjal( CircularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected CircularWall oval4;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval5_SetDynamicParams_xjal( CircularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected CircularWall oval5;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval6_SetDynamicParams_xjal( CircularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected CircularWall oval6;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval7_SetDynamicParams_xjal( CircularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected CircularWall oval7;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval8_SetDynamicParams_xjal( CircularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected CircularWall oval8;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _oval9_SetDynamicParams_xjal( CircularWall shape ) {
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
  }
  
  protected CircularWall oval9;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _window_SetDynamicParams_xjal( TargetLine shape ) {
    shape.setColor(
 
);
  }
  
  protected TargetLine window;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _coffee_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode coffee;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _area3_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode area3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _area3_2_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode area3_2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _area3_3_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode area3_3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _area3_4_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode area3_4;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _tofloor1_SetDynamicParams_xjal( Pathway shape ) {
    shape.setLineColor(
 
);
  }
  
  protected Pathway tofloor1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _area3_5_SetDynamicParams_xjal( RectangularNode shape ) {
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
  }
  
  protected RectangularNode area3_5;
  protected com.anylogic.engine.markup.Ground firstGround;
  protected com.anylogic.engine.markup.Ground secondGround;

  private com.anylogic.engine.markup.Ground[] _getGrounds_xjal;

  @Override
  public com.anylogic.engine.markup.Ground[] getGrounds() {
    return _getGrounds_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    checkbox = new ShapeCheckBox(
		Main.this,true,54.417, 83.0, 
		12.0, 17.0,
            transparent, controlDefault, true,
            _checkbox_Font,
			"" ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _checkbox_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action(){
        executeShapeControlAction( _checkbox, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox, 0 ) );
      }
    };

    button = new ShapeButton(
			Main.this, true, 1210.0, -80.0, 
			40.0, 50.0,
            controlDefault, _button_Text_Color, true,
            _button_Font, 
			"Fire Alarm!" ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _button_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action(){
        executeShapeControlAction( _button, 0 );
      }
    };

    sliderRange = new ShapeSlider(
		    Main.this, true, -270.0, 1355.0, 
			170.0, 40.0,
            transparent, true,
            false, getShapeControlMinimum( _sliderRange ), getShapeControlMaximum( _sliderRange ), ShapeControl.TYPE_DOUBLE ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _sliderRange_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action(){
        executeShapeControlAction( _sliderRange, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sliderRange, 0 ), getMax() ) );
      }
    };

    radioLayoutType = new ShapeRadioButtonGroup(
		    Main.this, true, -600.0, 1080.0, 
			160.0, 140.0,
            transparent, black, true,
            _radioLayoutType_Font, true, 
            new String[]{"User Defined", "Random", "Arranged", "Ring", "Spring Mass", } ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _radioLayoutType_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action(){
        executeShapeControlAction( _radioLayoutType, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( getShapeControlDefaultValueInt( _radioLayoutType, 0 ) );
      }
    };

    radioNetworkType = new ShapeRadioButtonGroup(
		    Main.this, true, -250.0, 1120.0, 
			150.0, 195.0,
            transparent, black, true,
            _radioNetworkType_Font, true, 
            new String[]{"None (user-defined)", "Random", "All in range", "Ring lattice", "Small world", "Scale free", } ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _radioNetworkType_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action(){
        executeShapeControlAction( _radioNetworkType, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( getShapeControlDefaultValueInt( _radioNetworkType, 0 ) );
      }
    };

    sliderConnectionsPerAgent = new ShapeSlider(
		    Main.this, true, -270.0, 1305.0, 
			170.0, 40.0,
            transparent, true,
            false, getShapeControlMinimum( _sliderConnectionsPerAgent ), getShapeControlMaximum( _sliderConnectionsPerAgent ), ShapeControl.TYPE_DOUBLE ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _sliderConnectionsPerAgent_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action(){
        executeShapeControlAction( _sliderConnectionsPerAgent, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sliderConnectionsPerAgent, 0 ), getMax() ) );
      }
    };

    sliderNeighborLinkProb = new ShapeSlider(
		    Main.this, true, -270.0, 1405.0, 
			170.0, 40.0,
            transparent, true,
            false, getShapeControlMinimum( _sliderNeighborLinkProb ), getShapeControlMaximum( _sliderNeighborLinkProb ), ShapeControl.TYPE_DOUBLE ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _sliderNeighborLinkProb_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action(){
        executeShapeControlAction( _sliderNeighborLinkProb, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sliderNeighborLinkProb, 0 ), getMax() ) );
      }
    };

    sliderScaleFreeM = new ShapeSlider(
		    Main.this, true, -260.0, 1300.0, 
			170.0, 40.0,
            transparent, true,
            false, getShapeControlMinimum( _sliderScaleFreeM ), getShapeControlMaximum( _sliderScaleFreeM ), ShapeControl.TYPE_INT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _sliderScaleFreeM_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action(){
        executeShapeControlAction( _sliderScaleFreeM, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _sliderScaleFreeM, 0 ), getMax() ) );
      }
    };

    radio = new ShapeRadioButtonGroup(
		    Main.this, true, -410.0, 1060.0, 
			110.0, 60.0,
            transparent, black, true,
            _radio_Font, false, 
            new String[]{"10 agents", "50 agents", "100 agents", "200 agents", "500 agents", } ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _radio_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action(){
        executeShapeControlAction( _radio, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( getShapeControlDefaultValueInt( _radio, 0 ) );
      }
    };

    checkbox1 = new ShapeCheckBox(
		Main.this,true,400.0, 40.0, 
		20.0, 17.0,
            transparent, controlDefault, true,
            _checkbox1_Font,
			"" ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _checkbox1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action(){
        executeShapeControlAction( _checkbox1, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox1, 0 ) );
      }
    };

    checkbox2 = new ShapeCheckBox(
		Main.this,true,410.0, 80.0, 
		20.0, 17.0,
            transparent, controlDefault, true,
            _checkbox2_Font,
			"" ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _checkbox2_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action(){
        executeShapeControlAction( _checkbox2, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox2, 0 ) );
      }
    };

    checkbox4 = new ShapeCheckBox(
		Main.this,true,560.0, 80.0, 
		20.0, 17.0,
            transparent, controlDefault, true,
            _checkbox4_Font,
			"" ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _checkbox4_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action(){
        executeShapeControlAction( _checkbox4, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox4, 0 ) );
      }
    };

    checkbox5 = new ShapeCheckBox(
		Main.this,true,544.0, 45.0, 
		20.0, 17.0,
            transparent, controlDefault, true,
            _checkbox5_Font,
			"" ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _checkbox5_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action(){
        executeShapeControlAction( _checkbox5, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox5, 0 ) );
      }
    };

    checkbox6 = new ShapeCheckBox(
		Main.this,true,710.0, 40.0, 
		20.0, 17.0,
            transparent, controlDefault, true,
            _checkbox6_Font,
			"" ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _checkbox6_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action(){
        executeShapeControlAction( _checkbox6, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox6, 0 ) );
      }
    };

    text2 = new ShapeText(
        SHAPE_DRAW_2D, true,200.0, 50.0, 0.0, 0.0, 
        navy,"00:00",
        _text2_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text2_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text3 = new ShapeText(
        SHAPE_DRAW_2D, true,190.0, 50.0, 0.0, 0.0, 
        black,"Evacuation time:",
        _text3_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text3_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    rectangle1 = new ShapeRectangle(
       SHAPE_DRAW_2D, false,0.0, 120.0, 0.0, 0.0, 
            null, null,
			540.0, 660.0, 0.0, 1.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _rectangle1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    rectangle1.setVisible( false );
    polyline = new ShapePolyLine(
		SHAPE_DRAW_2D, true, 553.0, 202.0, 0.0, black, null,
            4, _polyline_pointsDX_xjal(), _polyline_pointsDY_xjal(), _polyline_pointsDZ_xjal(), false, 10.0, 1.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line = new ShapeLine(
		SHAPE_DRAW_2D, true, -44.894, -25.016, 0.0, black, 
 		0.0,	50.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line1 = new ShapeLine(
		SHAPE_DRAW_2D, true, -40.812, -25.016, 0.0, black, 
 		0.0,	50.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line2 = new ShapeLine(
		SHAPE_DRAW_2D, true, -36.731, -25.016, 0.0, black, 
 		0.0,	50.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line2_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line3 = new ShapeLine(
		SHAPE_DRAW_2D, true, -32.65, -25.016, 0.0, black, 
 		0.0,	50.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line3_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line4 = new ShapeLine(
		SHAPE_DRAW_2D, true, -28.569, -25.016, 0.0, black, 
 		0.0,	50.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line4_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line5 = new ShapeLine(
		SHAPE_DRAW_2D, true, -24.488, -25.016, 0.0, black, 
 		0.0,	50.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line5_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line6 = new ShapeLine(
		SHAPE_DRAW_2D, true, -20.405, -25.016, 0.0, black, 
 		0.0,	50.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line6_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line7 = new ShapeLine(
		SHAPE_DRAW_2D, true, -16.325, -25.016, 0.0, black, 
 		0.0,	50.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line7_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line8 = new ShapeLine(
		SHAPE_DRAW_2D, true, -12.244, -25.016, 0.0, black, 
 		0.0,	50.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line8_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line9 = new ShapeLine(
		SHAPE_DRAW_2D, true, -8.162, -25.016, 0.0, black, 
 		0.0,	50.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line9_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line10 = new ShapeLine(
		SHAPE_DRAW_2D, true, -4.081, -25.016, 0.0, black, 
 		0.0,	50.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line10_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line11 = new ShapeLine(
		SHAPE_DRAW_2D, true, 0.0, -25.016, 0.0, black, 
 		0.0,	50.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line11_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line12 = new ShapeLine(
		SHAPE_DRAW_2D, true, 4.081, -25.016, 0.0, black, 
 		0.0,	50.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line12_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line13 = new ShapeLine(
		SHAPE_DRAW_2D, true, 8.162, -25.016, 0.0, black, 
 		0.0,	50.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line13_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line14 = new ShapeLine(
		SHAPE_DRAW_2D, true, 12.244, -25.016, 0.0, black, 
 		0.0,	50.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line14_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line15 = new ShapeLine(
		SHAPE_DRAW_2D, true, 16.325, -25.016, 0.0, black, 
 		0.0,	50.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line15_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line16 = new ShapeLine(
		SHAPE_DRAW_2D, true, 20.405, -25.016, 0.0, black, 
 		0.0,	50.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line16_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line17 = new ShapeLine(
		SHAPE_DRAW_2D, true, 24.488, -25.016, 0.0, black, 
 		0.0,	50.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line17_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line18 = new ShapeLine(
		SHAPE_DRAW_2D, true, 24.488, -25.016, 0.0, black, 
 		0.0,	50.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line18_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line19 = new ShapeLine(
		SHAPE_DRAW_2D, true, 28.569, -25.016, 0.0, black, 
 		0.0,	50.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line19_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line31 = new ShapeLine(
		SHAPE_DRAW_2D, true, 32.65, -25.016, 0.0, black, 
 		0.0,	50.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line31_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line32 = new ShapeLine(
		SHAPE_DRAW_2D, true, 36.731, -25.016, 0.0, black, 
 		0.0,	50.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line32_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line33 = new ShapeLine(
		SHAPE_DRAW_2D, true, 40.812, -25.016, 0.0, black, 
 		0.0,	50.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line33_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line34 = new ShapeLine(
		SHAPE_DRAW_2D, true, 40.812, -25.016, 0.0, black, 
 		0.0,	50.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line34_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line35 = new ShapeLine(
		SHAPE_DRAW_2D, true, 37.333, -28.033, 0.0, black, 
 		-2.0,	53.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line35_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line36 = new ShapeLine(
		SHAPE_DRAW_2D, true, 48.977, -25.016, 0.0, black, 
 		0.0,	50.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line36_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line37 = new ShapeLine(
		SHAPE_DRAW_2D, true, -23.734, -26.25, 0.0, black, 
 		0.0,	56.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line37_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line38 = new ShapeLine(
		SHAPE_DRAW_2D, true, -18.987, -26.25, 0.0, black, 
 		0.0,	56.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line38_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line39 = new ShapeLine(
		SHAPE_DRAW_2D, true, -14.241, -26.25, 0.0, black, 
 		0.0,	56.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line39_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line40 = new ShapeLine(
		SHAPE_DRAW_2D, true, -9.494, -26.25, 0.0, black, 
 		0.0,	56.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line40_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line41 = new ShapeLine(
		SHAPE_DRAW_2D, true, -4.747, -26.25, 0.0, black, 
 		0.0,	56.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line41_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line42 = new ShapeLine(
		SHAPE_DRAW_2D, true, 0.0, -26.25, 0.0, black, 
 		0.0,	56.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line42_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line43 = new ShapeLine(
		SHAPE_DRAW_2D, true, 4.747, -26.25, 0.0, black, 
 		0.0,	56.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line43_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line44 = new ShapeLine(
		SHAPE_DRAW_2D, true, 9.494, -26.25, 0.0, black, 
 		0.0,	56.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line44_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line45 = new ShapeLine(
		SHAPE_DRAW_2D, true, 14.241, -26.25, 0.0, black, 
 		0.0,	56.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line45_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line46 = new ShapeLine(
		SHAPE_DRAW_2D, true, 30.0, -20.0, 0.0, black, 
 		0.0,	46.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line46_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line47 = new ShapeLine(
		SHAPE_DRAW_2D, true, 23.734, -26.25, 0.0, black, 
 		0.0,	56.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line47_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line48 = new ShapeLine(
		SHAPE_DRAW_2D, true, 28.481, -26.25, 0.0, black, 
 		0.0,	56.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line48_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line49 = new ShapeLine(
		SHAPE_DRAW_2D, true, 33.228, -26.25, 0.0, black, 
 		0.0,	56.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line49_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line50 = new ShapeLine(
		SHAPE_DRAW_2D, true, -28.481, -26.25, 0.0, black, 
 		0.0,	56.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line50_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line51 = new ShapeLine(
		SHAPE_DRAW_2D, true, -33.228, -26.25, 0.0, black, 
 		0.0,	56.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line51_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line52 = new ShapeLine(
		SHAPE_DRAW_2D, true, -37.975, -26.25, 0.0, black, 
 		0.0,	56.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line52_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    rectangle2 = new ShapeRectangle(
       SHAPE_DRAW_2D, true,0.0, 20.0, 0.0, 0.0, 
            null, white,
			1100.0, 45.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _rectangle2_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    rectangle9 = new ShapeRectangle(
       SHAPE_DRAW_2D, true,0.0, 60.0, 0.0, 0.0, 
            null, _rectangle9_Fill_Color,
			1100.0, 6.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _rectangle9_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line53 = new ShapeLine(
		SHAPE_DRAW_2D, true, 0.0, 60.0, 0.0, navy, 
 		1100.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line53_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    textHead = new ShapeText(
        SHAPE_DRAW_2D, true,12.0, 25.0, 0.0, 0.0, 
        navy,"Evacuation model",
        _textHead_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _textHead_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text4 = new ShapeText(
        SHAPE_DRAW_2D, true,190.0, 140.0, 0.0, 0.0, 
        silver,"First Floor",
        _text4_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text4_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text5 = new ShapeText(
        SHAPE_DRAW_2D, true,700.0, 140.0, 0.0, 0.0, 
        silver,"Second Floor",
        _text5_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text5_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text6 = new ShapeText(
        SHAPE_DRAW_2D, true,-240.0, 1320.0, 0.0, 0.0, 
        black,"Statistics",
        _text6_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text6_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text7 = new ShapeText(
        SHAPE_DRAW_2D, true,60.0, 270.0, 0.0, 0.0, 
        silver,"WC",
        _text7_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text7_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text9 = new ShapeText(
        SHAPE_DRAW_2D, true,240.0, 610.0, 0.0, 0.0, 
        silver,"Smoke\r\nroom",
        _text9_Font, ALIGNMENT_CENTER ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text9_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text11 = new ShapeText(
        SHAPE_DRAW_2D, true,120.127, 80.0, 0.0, 0.0, 
        black,"    Additional exit:",
        _text11_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text11_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _text11, 0, clickx, clicky );
      }
    };

    text12 = new ShapeText(
        SHAPE_DRAW_2D, true,640.0, 300.0, 0.0, 0.0, 
        silver,"Cafeteria",
        _text12_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text12_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text13 = new ShapeText(
        SHAPE_DRAW_2D, true,40.0, -580.0, 0.0, 0.0, 
        navy,"Pedestrian library objects",
        _text13_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text13_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line72 = new ShapeLine(
		SHAPE_DRAW_2D, true, 40.0, -560.0, 0.0, black, 
 		190.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line72_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text14 = new ShapeText(
        SHAPE_DRAW_2D, true,260.0, -580.0, 0.0, 0.0, 
        navy,"Auxiliary functions",
        _text14_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text14_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line73 = new ShapeLine(
		SHAPE_DRAW_2D, true, 260.0, -560.0, 0.0, black, 
 		160.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line73_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text15 = new ShapeText(
        SHAPE_DRAW_2D, true,440.0, -580.0, 0.0, 0.0, 
        navy,"Timing",
        _text15_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text15_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line85 = new ShapeLine(
		SHAPE_DRAW_2D, true, 440.0, -560.0, 0.0, black, 
 		140.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line85_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line86 = new ShapeLine(
		SHAPE_DRAW_2D, true, 260.0, -480.0, 0.0, black, 
 		160.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line86_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text16 = new ShapeText(
        SHAPE_DRAW_2D, true,260.0, -500.0, 0.0, 0.0, 
        navy,"Arrival rates",
        _text16_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text16_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line87 = new ShapeLine(
		SHAPE_DRAW_2D, true, 260.0, -360.0, 0.0, black, 
 		160.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line87_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text17 = new ShapeText(
        SHAPE_DRAW_2D, true,260.0, -380.0, 0.0, 0.0, 
        navy,"Animation",
        _text17_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text17_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text8 = new ShapeText(
        SHAPE_DRAW_2D, true,70.0, 380.0, 0.0, 0.0, 
        silver,"WC",
        _text8_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text8_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline2 = new ShapePolyLine(
		SHAPE_DRAW_2D, true, -35.0, -15.0, 0.0, null, _polyline2_Fill_Color,
            5, _polyline2_pointsDX_xjal(), _polyline2_pointsDY_xjal(), _polyline2_pointsDZ_xjal(), true, 10.0, 1.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline2_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text10 = new ShapeText(
        SHAPE_DRAW_2D, true,-27.0, -14.0, 0.0, 0.0, 
        white,"Exit",
        _text10_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text10_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text20 = new ShapeText(
        SHAPE_DRAW_2D, true,180.0, 80.0, 0.0, 0.0, 
        black,"Time: ",
        _text20_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text20_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text21 = new ShapeText(
        SHAPE_DRAW_2D, true,180.0, 80.0, 0.0, 0.0, 
        navy,"00:00",
        _text21_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text21_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text18 = new ShapeText(
        SHAPE_DRAW_2D, true,-260.0, 1295.0, 0.0, 0.0, 
        black,"Connections per agent:",
        _text18_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text18_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text22 = new ShapeText(
        SHAPE_DRAW_2D, true,-260.0, 1345.0, 0.0, 0.0, 
        black,"Connection range:",
        _text22_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text22_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text23 = new ShapeText(
        SHAPE_DRAW_2D, true,-260.0, 1395.0, 0.0, 0.0, 
        black,"Neighbor link probability",
        _text23_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text23_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text24 = new ShapeText(
        SHAPE_DRAW_2D, true,-240.0, 1440.0, 0.0, 0.0, 
        black,"M (Scale Free parameter)",
        _text24_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text24_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line22 = new ShapeLine(
		SHAPE_DRAW_2D, true, -630.0, 1020.0, 0.0, steelBlue, 
 		180.0,	0.0, 0.0, 1.0, 0.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line22_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text25 = new ShapeText(
        SHAPE_DRAW_2D, true,-600.0, 1060.0, 0.0, 0.0, 
        navy,"Layout type",
        _text25_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text25_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line23 = new ShapeLine(
		SHAPE_DRAW_2D, true, -250.0, 1185.0, 0.0, steelBlue, 
 		180.0,	0.0, 0.0, 1.0, 0.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line23_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text26 = new ShapeText(
        SHAPE_DRAW_2D, true,-240.0, 1100.0, 0.0, 0.0, 
        navy,"Network type",
        _text26_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text26_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text27 = new ShapeText(
        SHAPE_DRAW_2D, true,-110.0, 1295.0, 0.0, 0.0, 
        steelBlue,"123",
        _text27_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text27_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text28 = new ShapeText(
        SHAPE_DRAW_2D, true,-130.0, 1360.0, 0.0, 0.0, 
        steelBlue,"123",
        _text28_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text28_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text29 = new ShapeText(
        SHAPE_DRAW_2D, true,-80.0, 1460.0, 0.0, 0.0, 
        steelBlue,"123",
        _text29_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text29_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text30 = new ShapeText(
        SHAPE_DRAW_2D, true,-110.0, 1395.0, 0.0, 0.0, 
        steelBlue,"123",
        _text30_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text30_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text31 = new ShapeText(
        SHAPE_DRAW_2D, true,550.0, 10.0, 0.0, 0.0, 
        black,"dead:",
        _text31_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text31_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

  }
  
  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP1_xjal() {
    text32 = new ShapeText(
        SHAPE_DRAW_2D, true,550.0, 10.0, 0.0, 0.0, 
        navy,"0",
        _text32_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text32_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text33 = new ShapeText(
        SHAPE_DRAW_2D, true,670.0, 10.0, 0.0, 0.0, 
        black,"survived:",
        _text33_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text33_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text34 = new ShapeText(
        SHAPE_DRAW_2D, true,670.0, 10.0, 0.0, 0.0, 
        navy,"0",
        _text34_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text34_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text35 = new ShapeText(
        SHAPE_DRAW_2D, true,390.0, 40.0, 0.0, 0.0, 
        black,"dynamic route",
        _text35_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text35_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text38 = new ShapeText(
        SHAPE_DRAW_2D, true,960.0, 10.0, 0.0, 0.0, 
        black,"help agent inside:",
        _text38_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text38_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text39 = new ShapeText(
        SHAPE_DRAW_2D, true,970.0, 10.0, 0.0, 0.0, 
        navy,"0",
        _text39_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text39_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text36 = new ShapeText(
        SHAPE_DRAW_2D, true,400.0, 70.0, 0.0, 0.0, 
        black,"dynamic route\r\n & help+ priorities",
        _text36_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text36_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text40 = new ShapeText(
        SHAPE_DRAW_2D, true,1080.0, 10.0, 0.0, 0.0, 
        navy,"0",
        _text40_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text40_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text41 = new ShapeText(
        SHAPE_DRAW_2D, true,1080.0, 10.0, 0.0, 0.0, 
        black,"total_help",
        _text41_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text41_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text37 = new ShapeText(
        SHAPE_DRAW_2D, true,880.0, 70.0, 0.0, 0.0, 
        black,"total survived\r\nwith help agent",
        _text37_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text37_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text42 = new ShapeText(
        SHAPE_DRAW_2D, true,890.0, 80.0, 0.0, 0.0, 
        navy,"0",
        _text42_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text42_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text44 = new ShapeText(
        SHAPE_DRAW_2D, true,560.0, 70.0, 0.0, 0.0, 
        black,"dynamic route \r\n& help",
        _text44_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text44_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    rectangle3 = new ShapeRectangle(
       SHAPE_DRAW_2D, false,550.0, 120.0, 0.0, 0.0, 
            null, null,
			540.0, 500.0, 0.0, 1.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _rectangle3_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    rectangle3.setVisible( false );
    text = new ShapeText(
        SHAPE_DRAW_2D, true,470.0, 10.0, 0.0, 0.0, 
        navy,"0",
        _text_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text1 = new ShapeText(
        SHAPE_DRAW_2D, true,460.0, 10.0, 0.0, 0.0, 
        black,"People inside the building:",
        _text1_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text45 = new ShapeText(
        SHAPE_DRAW_2D, true,540.0, 40.0, 0.0, 0.0, 
        black,"static: safest",
        _text45_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text45_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    oval12 = new ShapeOval(
       SHAPE_DRAW_2D3D, false,150.0, 40.0, 0.0, 0.0, 
       null, _oval12_Fill_Color,
	   50.0, 50.0, 0.0, 1.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _oval12_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    oval13 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,-20.0, 60.0, 0.0, 0.0, 
       null, _oval13_Fill_Color,
	   10.0, 10.0, 0.0, 1.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _oval13_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text46 = new ShapeText(
        SHAPE_DRAW_2D, true,710.0, 40.0, 0.0, 0.0, 
        black,"static: door_alert",
        _text46_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text46_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline3 = new ShapePolyLine(
		SHAPE_DRAW_2D, true, -32.91, -14.062, 0.0, null, _polyline3_Fill_Color,
            5, _polyline3_pointsDX_xjal(), _polyline3_pointsDY_xjal(), _polyline3_pointsDZ_xjal(), true, 10.0, 1.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline3_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text43 = new ShapeText(
        SHAPE_DRAW_2D, true,-25.388, -13.125, 0.0, 0.0, 
        white,"Exit",
        _text43_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text43_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text47 = new ShapeText(
        SHAPE_DRAW_2D, true,960.0, 40.0, 0.0, 0.0, 
        black,"success Rate",
        _text47_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text47_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    success = new ShapeText(
        SHAPE_DRAW_2D, true,960.0, 40.0, 0.0, 0.0, 
        navy,"0",
        _success_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _success_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text48 = new ShapeText(
        SHAPE_DRAW_2D, true,820.0, 40.0, 0.0, 0.0, 
        navy,"0",
        _text48_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text48_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text49 = new ShapeText(
        SHAPE_DRAW_2D, true,810.0, 40.0, 0.0, 0.0, 
        black,"trapped:",
        _text49_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text49_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    oval14 = new ShapeOval(
       SHAPE_DRAW_2D3D, true,200.0, -30.0, 0.0, 0.0, 
       null, _oval14_Fill_Color,
	   10.0, 10.0, 0.0, 1.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _oval14_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text50 = new ShapeText(
        SHAPE_DRAW_2D, true,760.0, 10.0, 0.0, 0.0, 
        navy,"0",
        _text50_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text50_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text51 = new ShapeText(
        SHAPE_DRAW_2D, true,760.0, 10.0, 0.0, 0.0, 
        black,"injured",
        _text51_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text51_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text52 = new ShapeText(
        SHAPE_DRAW_2D, true,1070.0, 70.0, 0.0, 0.0, 
        black,"injured survived\r\nwith help agent",
        _text52_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text52_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text53 = new ShapeText(
        SHAPE_DRAW_2D, true,1080.0, 80.0, 0.0, 0.0, 
        navy,"0",
        _text53_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text53_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text54 = new ShapeText(
        SHAPE_DRAW_2D, true,710.0, 80.0, 0.0, 0.0, 
        navy,"0",
        _text54_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text54_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text55 = new ShapeText(
        SHAPE_DRAW_2D, true,710.0, 80.0, 0.0, 0.0, 
        black,"inside & alive:",
        _text55_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text55_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text56 = new ShapeText(
        SHAPE_DRAW_2D, true,1160.0, 40.0, 0.0, 0.0, 
        black,"helper_success Rate",
        _text56_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text56_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    helper_success = new ShapeText(
        SHAPE_DRAW_2D, true,1170.0, 40.0, 0.0, 0.0, 
        navy,"0",
        _helper_success_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _helper_success_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    enter = new TargetLine( this, SHAPE_DRAW_2D, true, 520.0, 720.0, _enter_pointsDX_xjal(), _enter_pointsDY_xjal(), black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _enter_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line20 = new TargetLine( this, SHAPE_DRAW_2D, true, 20.0, 130.0, _line20_pointsDX_xjal(), _line20_pointsDY_xjal(), null ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line20_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    s8 = new RectangularNode( this, SHAPE_DRAW_2D, false, 190.0, 580.0, 0.0, 100.0, 120.0, 0.0,
            null, black, 2.0, LINE_STYLE_SOLID, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _s8_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    s8.setVisible( false );
    stairwayUp = new RectangularNode( this, SHAPE_DRAW_2D, true, 10.0, 120.0, 0.0, 110.0, 70.0, 0.0,
            null, black, 2.0, LINE_STYLE_SOLID, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _stairwayUp_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    stairwayUp.setVisible( false );
    line30 = new TargetLine( this, SHAPE_DRAW_2D, true, 530.0, 130.0, _line30_pointsDX_xjal(), _line30_pointsDY_xjal(), black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line30_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    queueLine = new QueuePath( EXCEEDED_QUEUE_EXTEND_TO_THE_FREE_SPACE, _queueLine_segments_xjal() );

    servicePoint = new ServicePoint<QueuePath>(50.0, 310.0, 3.141592653589793, null );

    servicePoint3 = new ServicePoint<QueuePath>(50.0, 390.0, 3.141592653589793, null );

    servicePoint4 = new ServicePoint<QueuePath>(50.0, 360.0, 3.141592653589793, null );

    servicePoint5 = new ServicePoint<QueuePath>(50.0, 330.0, 3.141592653589793, null );

    servicesWC = new ServiceWLine<ServicePoint<QueuePath>>(this, SHAPE_DRAW_2D3D, true, SERVICE_TYPE_POINT, false,
        new ServicePoint[] { servicePoint, servicePoint3, servicePoint4, servicePoint5, },
        new QueuePath[] { queueLine, }, null,
        SERVICE_QUEUE_CLOSEST_STRICT, false, green, green, magenta, SERVICE_GROUP_BEHAVIOR_SAME_FOR_ALL_GROUPS, SERVICE_GROUP_INDIVIDUAL_SERVING, null );

    polyline5 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline5_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline5_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline6 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline6_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline6_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline7 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline7_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline7_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline8 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline8_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline8_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline9 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline9_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline9_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline10 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline10_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline10_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline11 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline11_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline11_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline12 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline12_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline12_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline13 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline13_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline13_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline16 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline16_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline16_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    table6 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 405.0, 303.0, 0.0, 45.0, 21.0, 0.0, 1.0, 22.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _table6_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline17 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline17_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline17_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline18 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline18_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline18_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline20 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline20_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline20_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline21 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline21_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline21_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline22 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline22_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline22_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline24 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline24_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline24_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline25 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline25_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline25_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline26 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline26_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline26_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline27 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline27_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline27_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline28 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline28_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline28_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline29 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline29_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline29_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline30 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline30_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline30_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline31 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline31_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline31_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline38 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline38_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline38_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline39 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline39_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline39_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    wall = new Wall( this, SHAPE_DRAW_2D3D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _wall_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _wall_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    seat7 = new Attractor( 260.0, -270.0, 1.5707963267948966 );

    seat8 = new Attractor( 280.0, -210.0, 4.71238898038469 );

    seat9 = new Attractor( 280.0, -160.0, 2.8797932657906435 );

    seat10 = new Attractor( 280.0, -100.0, 2.8797932657906435 );

    seat11 = new Attractor( 280.0, -40.0, 3.141592653589793 );

    seat12 = new Attractor( 280.0, 20.0, 3.141592653589793 );

    seat13 = new Attractor( 280.0, 80.0, 2.8797932657906435 );

    seat14 = new Attractor( 217.0, 81.0, 0.0 );

    seat15 = new Attractor( 160.0, 20.0, 0.2617993877991494 );

    seat16 = new Attractor( 110.0, 5.0, 1.5707963267948966 );

    seat17 = new Attractor( 80.0, 160.0, 3.141592653589793 );

    seat18 = new Attractor( 90.0, 200.0, 3.141592653589793 );

    seat19 = new Attractor( 115.0, 120.0, 0.0 );

    seat20 = new Attractor( 115.0, 160.0, 0.0 );

    seat21 = new Attractor( 190.0, 200.0, 0.2617993877991494 );

    seat22 = new Attractor( 260.0, 200.0, 2.8797932657906435 );

    seat0 = new Attractor( -151.0, 27.0, 1.5707963267948966 );

    seat23 = new Attractor( 25.0, -25.0, 4.71238898038469 );

    seat1 = new Attractor( 30.0, -220.0, 0.0 );

    seat2 = new Attractor( 140.0, -250.0, 4.71238898038469 );

    seat3 = new Attractor( 190.0, -250.0, 4.71238898038469 );

    seat4 = new Attractor( 70.0, -140.0, 4.71238898038469 );

    seat5 = new Attractor( 120.0, -140.0, 4.71238898038469 );

    seat6 = new Attractor( 190.0, -140.0, 4.71238898038469 );

    workArea = new PolygonalNode( this, SHAPE_DRAW_2D3D, false, 240.0, 480.0, 0.0, _workArea_pointsDX_xjal(), _workArea_pointsDY_xjal(),  null, null, 2.0, LINE_STYLE_SOLID, POSITION_CHOICE_BY_ATTRACTORS, _workArea_attractors_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _workArea_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    workArea.setVisible( false );
    table16 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 325.0, 496.0, 0.0, 43.0, 22.0, 0.0, 1.0, 22.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _table16_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    table15 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 406.0, 496.0, 0.0, 43.0, 22.0, 0.0, 1.0, 22.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _table15_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    table0 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 63.0, 520.0, 0.0, 43.0, 21.0, 0.0, 1.0, 22.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _table0_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

  }
  
  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP2_xjal() {
    table23 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 280.0, 430.0, 0.0, 8.0, 10.0, 0.0, 1.0, 22.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _table23_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    table4 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 275.0, 303.0, 0.0, 43.0, 21.0, 0.0, 1.0, 22.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _table4_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    table5 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 342.0, 303.0, 0.0, 43.0, 21.0, 0.0, 1.0, 22.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _table5_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    table2 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 355.0, 196.0, 0.0, 43.0, 21.0, 0.0, 1.0, 22.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _table2_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    table3 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 405.0, 196.0, 0.0, 42.0, 21.0, 0.0, 1.0, 22.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _table3_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    table1 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 299.0, 254.0, 0.0, 26.0, 21.0, 1.5707963267948966, 1.0, 22.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _table1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    table7 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 493.0, 220.0, 0.0, 42.0, 21.0, 0.0, 1.0, 22.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _table7_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    table8 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 493.0, 242.0, 0.0, 42.0, 21.0, 0.0, 1.0, 22.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _table8_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    table9 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 509.0, 297.0, 0.0, 13.0, 9.0, 1.5707963267948966, 1.0, 22.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _table9_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    table10 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 510.0, 360.0, 0.0, 10.0, 10.0, 1.5707963267948966, 1.0, 22.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _table10_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    table11 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 510.0, 450.0, 0.0, 9.0, 0.0, 1.5707963267948966, 1.0, 22.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _table11_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    table12 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 509.0, 476.0, 0.0, 42.0, 21.0, 1.5707963267948966, 1.0, 22.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _table12_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    table13 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 510.0, 540.0, 0.0, 42.0, 21.0, 1.5707963267948966, 1.0, 22.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _table13_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    table14 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 488.0, 538.0, 0.0, 42.0, 21.0, 1.5707963267948966, 1.0, 22.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _table14_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    table17 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 312.0, 620.0, 0.0, 42.0, 21.0, 1.5707963267948966, 1.0, 22.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _table17_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    table18 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 312.0, 662.0, 0.0, 42.0, 21.0, 1.5707963267948966, 1.0, 22.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _table18_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    table19 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 388.0, 577.0, 0.0, 41.0, 21.0, 1.5707963267948966, 1.0, 22.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _table19_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    table20 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 388.0, 618.0, 0.0, 42.0, 21.0, 1.5707963267948966, 1.0, 22.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _table20_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    table21 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 466.0, 662.0, 0.0, 42.0, 21.0, 1.5707963267948966, 1.0, 22.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _table21_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    table22 = new RectangularWall(this, SHAPE_DRAW_2D3D, true, 490.0, 662.0, 0.0, 42.0, 21.0, 1.5707963267948966, 1.0, 22.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _table22_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    area1 = new PolygonalNode( this, SHAPE_DRAW_2D3D, true, 110.0, 490.0, 0.0, _area1_pointsDX_xjal(), _area1_pointsDY_xjal(),  null, null, 2.0, LINE_STYLE_DASHED, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _area1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    area2 = new RectangularNode( this, SHAPE_DRAW_2D3D, true, 10.0, 120.0, 0.0, 520.0, 70.0, 0.0,
            null, null, 2.0, LINE_STYLE_DASHED, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _area2_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    area4 = new RectangularNode( this, SHAPE_DRAW_2D3D, true, 110.0, 190.0, 0.0, 70.0, 270.0, 0.0,
            null, null, 2.0, LINE_STYLE_DASHED, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _area4_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    ex2 = new Pathway( this, SHAPE_DRAW_2D, false, null, _ex2_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _ex2_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    ex2.setVisible( false );
    ex1 = new Pathway( this, SHAPE_DRAW_2D, false, null, _ex1_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _ex1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    ex1.setVisible( false );
    office = new Pathway( this, SHAPE_DRAW_2D, false, null, _office_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _office_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    office.setVisible( false );
    s1 = new RectangularNode( this, SHAPE_DRAW_2D3D, false, 250.0, 190.0, 0.0, 200.0, 170.0, 0.0,
            null, null, 4.0, LINE_STYLE_SOLID, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _s1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    s1.setVisible( false );
    s3_1 = new RectangularNode( this, SHAPE_DRAW_2D3D, false, 450.0, 190.0, 0.0, 90.0, 410.0, 0.0,
            null, null, 2.0, LINE_STYLE_DASHED, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _s3_1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    s3_1.setVisible( false );
    s5 = new RectangularNode( this, SHAPE_DRAW_2D3D, false, 300.0, 360.0, 0.0, 150.0, 110.0, 0.0,
            null, null, 2.0, LINE_STYLE_DASHED, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _s5_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    s5.setVisible( false );
    s4 = new RectangularNode( this, SHAPE_DRAW_2D3D, false, 290.0, 580.0, 0.0, 100.0, 120.0, 0.0,
            null, null, 2.0, LINE_STYLE_DASHED, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _s4_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    s4.setVisible( false );
    s2 = new RectangularNode( this, SHAPE_DRAW_2D3D, false, 180.0, 360.0, 0.0, 120.0, 110.0, 0.0,
            null, null, 2.0, LINE_STYLE_DASHED, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _s2_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    s2.setVisible( false );
    s6 = new RectangularNode( this, SHAPE_DRAW_2D3D, false, 20.0, 460.0, 0.0, 90.0, 80.0, 0.0,
            null, null, 2.0, LINE_STYLE_DASHED, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _s6_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    s6.setVisible( false );
    s7 = new RectangularNode( this, SHAPE_DRAW_2D3D, false, 20.0, 190.0, 0.0, 90.0, 260.0, 0.0,
            null, null, 2.0, LINE_STYLE_DASHED, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _s7_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    s7.setVisible( false );
    s3_3 = new RectangularNode( this, SHAPE_DRAW_2D3D, false, 400.0, 580.0, 0.0, 130.0, 120.0, 0.0,
            null, null, 2.0, LINE_STYLE_DASHED, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _s3_3_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    s3_3.setVisible( false );
    polyline23 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline23_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline23_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    s3_2 = new RectangularNode( this, SHAPE_DRAW_2D3D, false, 190.0, 470.0, 0.0, 260.0, 110.0, 0.0,
            null, null, 4.0, LINE_STYLE_SOLID, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _s3_2_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    s3_2.setVisible( false );
    area1_1 = new RectangularNode( this, SHAPE_DRAW_2D3D, false, 120.0, 710.0, 0.0, 400.0, 70.0, 0.0,
            null, green, 2.0, LINE_STYLE_DASHED, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _area1_1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    area1_1.setVisible( false );
    area1_2 = new RectangularNode( this, SHAPE_DRAW_2D3D, false, 110.0, 460.0, 0.0, 80.0, 250.0, 0.0,
            null, green, 2.0, LINE_STYLE_DASHED, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _area1_2_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    area1_2.setVisible( false );
    office1 = new Pathway( this, SHAPE_DRAW_2D, false, null, _office1_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _office1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    office1.setVisible( false );
    s3_4 = new RectangularNode( this, SHAPE_DRAW_2D3D, false, 440.0, 190.0, 0.0, 100.0, 270.0, 0.0,
            null, null, 2.0, LINE_STYLE_DASHED, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _s3_4_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    s3_4.setVisible( false );
    s3_5 = new RectangularNode( this, SHAPE_DRAW_2D3D, false, 480.0, 290.0, 0.0, 50.0, 60.0, 0.0,
            null, null, 2.0, LINE_STYLE_DASHED, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _s3_5_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    s3_5.setVisible( false );
    area4_1 = new RectangularNode( this, SHAPE_DRAW_2D3D, true, 10.0, 120.0, 0.0, 280.0, 250.0, 0.0,
            null, null, 2.0, LINE_STYLE_DASHED, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _area4_1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    area4_2 = new RectangularNode( this, SHAPE_DRAW_2D3D, true, 110.0, 570.0, 0.0, 100.0, 210.0, 0.0,
            null, null, 2.0, LINE_STYLE_DASHED, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _area4_2_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    out = new Pathway( this, SHAPE_DRAW_2D, false, null, _out_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _out_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    out.setVisible( false );
    line21 = new TargetLine( this, SHAPE_DRAW_2D, true, 1050.0, 140.0, _line21_pointsDX_xjal(), _line21_pointsDY_xjal(), null ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line21_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    attractor = new Attractor( 43.0, 182.0, 4.71238898038469 );

    attractor1 = new Attractor( 57.0, 174.0, 3.6651914291880923 );

    attractor2 = new Attractor( 58.0, 157.0, 2.6179938779914944 );

    attractor3 = new Attractor( 43.0, 147.0, 1.5707963267948966 );

    attractor4 = new Attractor( 27.0, 158.0, 0.5235987755982988 );

    attractor5 = new Attractor( 28.0, 174.0, 6.021385919380437 );

    attractor6 = new Attractor( 111.0, 150.0, 1.5707963267948966 );

    attractor7 = new Attractor( 95.0, 161.0, 0.5235987755982988 );

    attractor8 = new Attractor( 96.0, 177.0, 6.021385919380437 );

    attractor9 = new Attractor( 111.0, 185.0, 4.71238898038469 );

    attractor10 = new Attractor( 125.0, 177.0, 3.6651914291880923 );

    attractor11 = new Attractor( 126.0, 160.0, 2.6179938779914944 );

    attractor12 = new Attractor( 161.0, 153.0, 1.0471975511965976 );

    attractor13 = new Attractor( 152.0, 168.0, 0.0 );

    attractor14 = new Attractor( 162.0, 184.0, 5.235987755982989 );

    attractor15 = new Attractor( 178.0, 183.0, 3.9269908169872414 );

    attractor16 = new Attractor( 186.0, 168.0, 3.141592653589793 );

    attractor17 = new Attractor( 179.0, 153.0, 2.0943951023931953 );

    attractor18 = new Attractor( 236.0, 154.0, 2.0943951023931953 );

    attractor19 = new Attractor( 218.0, 154.0, 1.0471975511965976 );

    attractor20 = new Attractor( 209.0, 169.0, 0.0 );

    attractor21 = new Attractor( 219.0, 185.0, 5.235987755982989 );

    attractor22 = new Attractor( 235.0, 184.0, 3.9269908169872414 );

    attractor23 = new Attractor( 243.0, 169.0, 3.141592653589793 );

    attractor24 = new Attractor( 235.0, 75.0, 2.0943951023931953 );

    attractor25 = new Attractor( 217.0, 75.0, 1.0471975511965976 );

    attractor26 = new Attractor( 208.0, 90.0, 0.0 );

    attractor27 = new Attractor( 218.0, 106.0, 5.235987755982989 );

    attractor28 = new Attractor( 234.0, 105.0, 3.9269908169872414 );

    attractor29 = new Attractor( 242.0, 90.0, 3.141592653589793 );

    attractor30 = new Attractor( 177.0, 74.0, 2.0943951023931953 );

    attractor31 = new Attractor( 159.0, 74.0, 1.0471975511965976 );

    attractor32 = new Attractor( 150.0, 89.0, 0.0 );

    attractor33 = new Attractor( 160.0, 105.0, 5.235987755982989 );

    attractor34 = new Attractor( 176.0, 104.0, 3.9269908169872414 );

    attractor35 = new Attractor( 184.0, 89.0, 3.141592653589793 );

    attractor36 = new Attractor( 107.0, 74.0, 2.0943951023931953 );

    attractor37 = new Attractor( 89.0, 74.0, 1.0471975511965976 );

    attractor38 = new Attractor( 80.0, 89.0, 0.0 );

    attractor39 = new Attractor( 90.0, 105.0, 5.235987755982989 );

    attractor40 = new Attractor( 106.0, 104.0, 3.9269908169872414 );

    attractor41 = new Attractor( 114.0, 89.0, 3.141592653589793 );

    attractor42 = new Attractor( 51.0, 73.0, 2.0943951023931953 );

    attractor43 = new Attractor( 33.0, 73.0, 1.0471975511965976 );

    attractor44 = new Attractor( 24.0, 88.0, 0.0 );

    attractor45 = new Attractor( 34.0, 104.0, 5.235987755982989 );

    attractor46 = new Attractor( 50.0, 103.0, 3.9269908169872414 );

    attractor47 = new Attractor( 58.0, 88.0, 3.141592653589793 );

    attractor48 = new Attractor( 51.0, 17.0, 2.0943951023931953 );

    attractor49 = new Attractor( 33.0, 17.0, 1.0471975511965976 );

    attractor50 = new Attractor( 24.0, 32.0, 0.0 );

    attractor51 = new Attractor( 34.0, 48.0, 5.235987755982989 );

    attractor52 = new Attractor( 50.0, 47.0, 3.9269908169872414 );

    attractor53 = new Attractor( 58.0, 32.0, 3.141592653589793 );

    attractor54 = new Attractor( 106.0, 17.0, 2.0943951023931953 );

  }
  
  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP3_xjal() {
    attractor55 = new Attractor( 88.0, 17.0, 1.0471975511965976 );

    attractor56 = new Attractor( 79.0, 32.0, 0.0 );

    attractor57 = new Attractor( 89.0, 48.0, 5.235987755982989 );

    attractor58 = new Attractor( 105.0, 47.0, 3.9269908169872414 );

    attractor59 = new Attractor( 113.0, 32.0, 3.141592653589793 );

    attractor60 = new Attractor( 174.0, 15.0, 2.0943951023931953 );

    attractor61 = new Attractor( 156.0, 15.0, 1.0471975511965976 );

    attractor62 = new Attractor( 147.0, 30.0, 0.0 );

    attractor63 = new Attractor( 157.0, 46.0, 5.235987755982989 );

    attractor64 = new Attractor( 173.0, 45.0, 3.9269908169872414 );

    attractor65 = new Attractor( 181.0, 30.0, 3.141592653589793 );

    attractor66 = new Attractor( 230.0, 15.0, 2.0943951023931953 );

    attractor67 = new Attractor( 212.0, 15.0, 1.0471975511965976 );

    attractor68 = new Attractor( 203.0, 30.0, 0.0 );

    attractor69 = new Attractor( 213.0, 46.0, 5.235987755982989 );

    attractor70 = new Attractor( 229.0, 45.0, 3.9269908169872414 );

    attractor71 = new Attractor( 237.0, 30.0, 3.141592653589793 );

    cafeteria = new RectangularNode( this, SHAPE_DRAW_2D, true, 550.0, 190.0, 0.0, 300.0, 220.0, 0.0,
            null, black, 1.0, LINE_STYLE_SOLID, POSITION_CHOICE_BY_ATTRACTORS, _cafeteria_attractors_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _cafeteria_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    cafeteria.setVisible( false );
    stairwayDown = new RectangularNode( this, SHAPE_DRAW_2D, true, 950.0, 122.0, 0.0, 123.0, 78.0, 0.0,
            null, black, 2.0, LINE_STYLE_SOLID, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _stairwayDown_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    stairwayDown.setVisible( false );
    polyline32 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline32_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline32_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline33 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline33_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline33_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline34 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline34_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline34_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline36 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline36_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline36_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline37 = new Wall( this, SHAPE_DRAW_2D, true, WALL_FILL_NONE, peru, 2.0, 20.0, _polyline37_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline37_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    oval = new CircularWall(this, SHAPE_DRAW_2D, true, 776.0, 359.0, 0.0, 11.0, 11.0, 0.0, 1.0, 20.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _oval_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    oval1 = new CircularWall(this, SHAPE_DRAW_2D, true, 718.0, 358.0, 0.0, 11.0, 11.0, 0.0, 1.0, 20.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _oval1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    oval10 = new CircularWall(this, SHAPE_DRAW_2D, true, 646.0, 222.0, 0.0, 11.0, 11.0, 0.0, 1.0, 20.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _oval10_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    oval11 = new CircularWall(this, SHAPE_DRAW_2D, true, 590.0, 222.0, 0.0, 11.0, 11.0, 0.0, 1.0, 20.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _oval11_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    oval2 = new CircularWall(this, SHAPE_DRAW_2D, true, 661.0, 357.0, 0.0, 11.0, 11.0, 0.0, 1.0, 20.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _oval2_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    oval3 = new CircularWall(this, SHAPE_DRAW_2D, true, 593.0, 354.0, 0.0, 11.0, 11.0, 0.0, 1.0, 20.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _oval3_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    oval4 = new CircularWall(this, SHAPE_DRAW_2D, true, 774.0, 280.0, 0.0, 11.0, 11.0, 0.0, 1.0, 20.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _oval4_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    oval5 = new CircularWall(this, SHAPE_DRAW_2D, true, 717.0, 279.0, 0.0, 11.0, 11.0, 0.0, 1.0, 20.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _oval5_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    oval6 = new CircularWall(this, SHAPE_DRAW_2D, true, 646.0, 279.0, 0.0, 11.0, 11.0, 0.0, 1.0, 20.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _oval6_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    oval7 = new CircularWall(this, SHAPE_DRAW_2D, true, 590.0, 278.0, 0.0, 11.0, 11.0, 0.0, 1.0, 20.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _oval7_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    oval8 = new CircularWall(this, SHAPE_DRAW_2D, true, 770.0, 220.0, 0.0, 11.0, 11.0, 0.0, 1.0, 20.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _oval8_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    oval9 = new CircularWall(this, SHAPE_DRAW_2D, true, 713.0, 220.0, 0.0, 11.0, 11.0, 0.0, 1.0, 20.0,
            WALL_FILL_NONE, black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _oval9_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    window = new TargetLine( this, SHAPE_DRAW_2D, true, 1000.0, 560.0, _window_pointsDX_xjal(), _window_pointsDY_xjal(), black ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _window_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    coffee = new RectangularNode( this, SHAPE_DRAW_2D3D, true, 550.0, 190.0, 0.0, 300.0, 220.0, 0.0,
            null, green, 2.0, LINE_STYLE_DASHED, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _coffee_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    coffee.setVisible( false );
    area3 = new RectangularNode( this, SHAPE_DRAW_2D3D, false, 850.0, 120.0, 0.0, 220.0, 200.0, 0.0,
            null, green, 2.0, LINE_STYLE_DASHED, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _area3_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    area3.setVisible( false );
    area3_2 = new RectangularNode( this, SHAPE_DRAW_2D3D, false, 850.0, 320.0, 0.0, 220.0, 190.0, 0.0,
            null, green, 2.0, LINE_STYLE_DASHED, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _area3_2_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    area3_2.setVisible( false );
    area3_3 = new RectangularNode( this, SHAPE_DRAW_2D3D, false, 550.0, 120.0, 0.0, 300.0, 70.0, 0.0,
            null, green, 2.0, LINE_STYLE_DASHED, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _area3_3_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    area3_3.setVisible( false );
    area3_4 = new RectangularNode( this, SHAPE_DRAW_2D3D, false, 680.0, 280.0, 0.0, 170.0, 120.0, 0.0,
            null, green, 2.0, LINE_STYLE_DASHED, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _area3_4_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    area3_4.setVisible( false );
    tofloor1 = new Pathway( this, SHAPE_DRAW_2D, false, null, _tofloor1_segments_xjal() ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _tofloor1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    tofloor1.setVisible( false );
    area3_5 = new RectangularNode( this, SHAPE_DRAW_2D3D, false, 560.0, 350.0, 0.0, 70.0, 40.0, 0.0,
            null, green, 2.0, LINE_STYLE_DASHED, POSITION_CHOICE_RANDOM ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _area3_5_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    area3_5.setVisible( false );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    DataSet _item;
    List<DataSet> _items = new ArrayList<DataSet>( 3 );
    _items.add( _plot_expression0_dataSet_xjal ); 
    _items.add( _plot_expression1_dataSet_xjal ); 
    _item = 
evacuationStart 
    ;
    _items.add( _item ); 
    List<String> _titles = new ArrayList<String>( 3 );
    _titles.add( "success_rate" );
    _titles.add( " PeopleInside" );
    _titles.add( "Dataset(time,inside)" );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<Chart2DPlot.Appearance>( 3 );
    _appearances.add( new Chart2DPlot.Appearance( green, true, Chart.INTERPOLATION_LINEAR, 2.0, Chart.POINT_NONE ) );
    _appearances.add( new Chart2DPlot.Appearance( blue, true, Chart.INTERPOLATION_LINEAR, 2.0, Chart.POINT_NONE ) );
    _appearances.add( new Chart2DPlot.Appearance( goldenRod, true, Chart.INTERPOLATION_LINEAR, 2.0, Chart.POINT_NONE ) );
    plot = new TimePlot(
		    Main.this, true, 550.0, 590.0, 
			540.0, 320.0,
            null, null,
            40.0, 20.0,
			480.0, 210.0, white, black, black,
            40.0, Chart.SOUTH,
            
200 
            , Chart.WINDOW_MOVES_WITH_DATA, null, Chart.SCALE_FIXED,
            
0 
            , 
100 
            , Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _appearances ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _plot_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    }
    {				
    groupFloor1 = new ShapeGroup( Main.this, SHAPE_DRAW_2D, true, 269.0, 440.0, 0.0, 0.0
	 ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _groupFloor1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void onDraw( Panel panel, Graphics2D graphics ) {
        onShapeGroupDraw( _groupFloor1, 0, panel, graphics );
      }
    };

    }
    {				
    groupDinnerTable = new ShapeGroup( Main.this, SHAPE_DRAW_2D, true, -170.0, -90.0, 0.0, 0.0
	 ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _groupDinnerTable_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void onDraw( Panel panel, Graphics2D graphics ) {
        onShapeGroupDraw( _groupDinnerTable, 0, panel, graphics );
      }
    };

    }
    {				
    groupFloor2 = new ShapeGroup( Main.this, SHAPE_DRAW_2D, true, 820.0, 360.0, 0.0, 0.0
	
	     ,groupDinnerTable ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _groupFloor2_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void onDraw( Panel panel, Graphics2D graphics ) {
        onShapeGroupDraw( _groupFloor2, 0, panel, graphics );
      }
    };

    }
    {				
    groupSt1 = new ShapeGroup( Main.this, SHAPE_DRAW_2D, true, 70.0, 150.0, 0.0, 3.141592653589793
	
	     ,line
	     ,line1
	     ,line2
	     ,line3
	     ,line4
	     ,line5
	     ,line6
	     ,line7
	     ,line8
	     ,line9
	     ,line10
	     ,line11
	     ,line12
	     ,line13
	     ,line14
	     ,line15
	     ,line16
	     ,line17
	     ,line18
	     ,line19
	     ,line31
	     ,line32
	     ,line33
	     ,line34
	     ,line35
	     ,line36 ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _groupSt1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void onDraw( Panel panel, Graphics2D graphics ) {
        onShapeGroupDraw( _groupSt1, 0, panel, graphics );
      }
    };

    }
    {				
    groupSt2 = new ShapeGroup( Main.this, SHAPE_DRAW_2D, true, 1030.0, 150.0, 0.0, 0.0
	
	     ,line37
	     ,line38
	     ,line39
	     ,line40
	     ,line41
	     ,line42
	     ,line43
	     ,line44
	     ,line45
	     ,line46
	     ,line47
	     ,line48
	     ,line49
	     ,line50
	     ,line51
	     ,line52 ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _groupSt2_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void onDraw( Panel panel, Graphics2D graphics ) {
        onShapeGroupDraw( _groupSt2, 0, panel, graphics );
      }
    };

    }
    {				
    groupMainMenu = new ShapeGroup( Main.this, SHAPE_DRAW_2D, true, 0.0, -20.0, 0.0, 0.0
	
	     ,rectangle2
	     ,rectangle9
	     ,line53
	     ,textHead ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _groupMainMenu_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void onDraw( Panel panel, Graphics2D graphics ) {
        onShapeGroupDraw( _groupMainMenu, 0, panel, graphics );
      }
    };

    }
    {
    evacuation_presentation = new ShapeEmbeddedObjectPresentation( Main.this, SHAPE_DRAW_2D, true, -150.0, 890.0, 0.0, 0.0,
		false, true, evacuation ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _evacuation_presentation_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    }
    {				
    group2 = new ShapeGroup( Main.this, SHAPE_DRAW_2D, true, 500.0, 740.0, 0.0, 0.0
	
	     ,polyline2
	     ,text10 ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _group2_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void onDraw( Panel panel, Graphics2D graphics ) {
        onShapeGroupDraw( _group2, 0, panel, graphics );
      }
    };

    }
    myAgent_presentation = new ShapeAgentPopulationGroup(this, SHAPE_DRAW_2D, true, myAgent) {
    
      @Override
      public ShapeEmbeddedObjectPresentation createShapeWithStaticProperties_xjal( final Agent _a, int index ) {
        ShapeEmbeddedObjectPresentation _e = _myAgent_presentation_createShapeWithStaticProperties_xjal( _a, index );
        return _e;
      }
      
      @Override
      public void setShapeDynamicProperties_xjal( ShapeEmbeddedObjectPresentation shape, int index ) {
        _myAgent_presentation_SetDynamicParams_xjal( shape, index );
      }
    };
    visitor_presentation = new ShapeAgentPopulationGroup(this, SHAPE_DRAW_2D3D, true, visitor) {
    
      @Override
      public ShapeEmbeddedObjectPresentation createShapeWithStaticProperties_xjal( final Agent _a, int index ) {
        ShapeEmbeddedObjectPresentation _e = _visitor_presentation_createShapeWithStaticProperties_xjal( _a, index );
        return _e;
      }
      
      @Override
      public void setShapeDynamicProperties_xjal( ShapeEmbeddedObjectPresentation shape, int index ) {
        _visitor_presentation_SetDynamicParams_xjal( shape, index );
      }
    };
    {				
    group4 = new ShapeGroup( Main.this, SHAPE_DRAW_2D, true, 460.0, 100.0, 0.0, 0.0
	
	     ,polyline3
	     ,text43 ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _group4_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void onDraw( Panel panel, Graphics2D graphics ) {
        onShapeGroupDraw( _group4, 0, panel, graphics );
      }
    };

    }
  }


  // Static initialization of persistent elements
  {
    firstGround = new com.anylogic.engine.markup.Ground(this, "firstGround", SHAPE_DRAW_2D3D, 0.0, true, true);  			
	_getGrounds_xjal = new com.anylogic.engine.markup.Ground[] { 
      firstGround,
      secondGround };
    secondGround = new com.anylogic.engine.markup.Ground(this, "secondGround", SHAPE_DRAW_2D3D, 0.0, true, true);  			
	_getGrounds_xjal = new com.anylogic.engine.markup.Ground[] { 
      firstGround,
      secondGround };
    _createPersistentElementsBP0_xjal();
    _createPersistentElementsBP1_xjal();
    _createPersistentElementsBP2_xjal();
    _createPersistentElementsBP3_xjal();
  }
  protected ShapeTopLevelPresentationGroup presentation;
  protected ShapeModelElementsGroup icon; 

  @Override
  @AnyLogicInternalCodegenAPI
  public ShapeTopLevelPresentationGroup getPresentationShape() {
    return presentation;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public ShapeModelElementsGroup getModelElementsShape() {
    return icon;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public Object getPersistentShape( int _shape ) {
    switch (_shape) {
      case _presentation: return presentation;
      case _icon: return icon;
      case _checkbox: return checkbox;
      case _button: return button;
      case _sliderRange: return sliderRange;
      case _radioLayoutType: return radioLayoutType;
      case _radioNetworkType: return radioNetworkType;
      case _sliderConnectionsPerAgent: return sliderConnectionsPerAgent;
      case _sliderNeighborLinkProb: return sliderNeighborLinkProb;
      case _sliderScaleFreeM: return sliderScaleFreeM;
      case _radio: return radio;
      case _checkbox1: return checkbox1;
      case _checkbox2: return checkbox2;
      case _checkbox4: return checkbox4;
      case _checkbox5: return checkbox5;
      case _checkbox6: return checkbox6;
      case _plot: return plot;
      case _groupFloor1: return groupFloor1;
      case _groupDinnerTable: return groupDinnerTable;
      case _groupFloor2: return groupFloor2;
      case _text2: return text2;
      case _text3: return text3;
      case _rectangle1: return rectangle1;
      case _polyline: return polyline;
      case _line: return line;
      case _line1: return line1;
      case _line2: return line2;
      case _line3: return line3;
      case _line4: return line4;
      case _line5: return line5;
      case _line6: return line6;
      case _line7: return line7;
      case _line8: return line8;
      case _line9: return line9;
      case _line10: return line10;
      case _line11: return line11;
      case _line12: return line12;
      case _line13: return line13;
      case _line14: return line14;
      case _line15: return line15;
      case _line16: return line16;
      case _line17: return line17;
      case _line18: return line18;
      case _line19: return line19;
      case _line31: return line31;
      case _line32: return line32;
      case _line33: return line33;
      case _line34: return line34;
      case _line35: return line35;
      case _line36: return line36;
      case _groupSt1: return groupSt1;
      case _line37: return line37;
      case _line38: return line38;
      case _line39: return line39;
      case _line40: return line40;
      case _line41: return line41;
      case _line42: return line42;
      case _line43: return line43;
      case _line44: return line44;
      case _line45: return line45;
      case _line46: return line46;
      case _line47: return line47;
      case _line48: return line48;
      case _line49: return line49;
      case _line50: return line50;
      case _line51: return line51;
      case _line52: return line52;
      case _groupSt2: return groupSt2;
      case _rectangle2: return rectangle2;
      case _rectangle9: return rectangle9;
      case _line53: return line53;
      case _textHead: return textHead;
      case _groupMainMenu: return groupMainMenu;
      case _text4: return text4;
      case _text5: return text5;
      case _evacuation_presentation: return evacuation_presentation;
      case _text6: return text6;
      case _text7: return text7;
      case _text9: return text9;
      case _text11: return text11;
      case _text12: return text12;
      case _text13: return text13;
      case _line72: return line72;
      case _text14: return text14;
      case _line73: return line73;
      case _text15: return text15;
      case _line85: return line85;
      case _line86: return line86;
      case _text16: return text16;
      case _line87: return line87;
      case _text17: return text17;
      case _text8: return text8;
      case _polyline2: return polyline2;
      case _text10: return text10;
      case _group2: return group2;
      case _text20: return text20;
      case _text21: return text21;
      case _text18: return text18;
      case _text22: return text22;
      case _text23: return text23;
      case _text24: return text24;
      case _line22: return line22;
      case _text25: return text25;
      case _line23: return line23;
      case _text26: return text26;
      case _text27: return text27;
      case _text28: return text28;
      case _text29: return text29;
      case _text30: return text30;
      case _myAgent_presentation: return myAgent_presentation;
      case _text31: return text31;
      case _text32: return text32;
      case _visitor_presentation: return visitor_presentation;
      case _text33: return text33;
      case _text34: return text34;
      case _text35: return text35;
      case _text38: return text38;
      case _text39: return text39;
      case _text36: return text36;
      case _text40: return text40;
      case _text41: return text41;
      case _text37: return text37;
      case _text42: return text42;
      case _text44: return text44;
      case _rectangle3: return rectangle3;
      case _text: return text;
      case _text1: return text1;
      case _text45: return text45;
      case _oval12: return oval12;
      case _oval13: return oval13;
      case _text46: return text46;
      case _polyline3: return polyline3;
      case _text43: return text43;
      case _group4: return group4;
      case _text47: return text47;
      case _success: return success;
      case _text48: return text48;
      case _text49: return text49;
      case _oval14: return oval14;
      case _text50: return text50;
      case _text51: return text51;
      case _text52: return text52;
      case _text53: return text53;
      case _text54: return text54;
      case _text55: return text55;
      case _text56: return text56;
      case _helper_success: return helper_success;
      case _enter: return enter;
      case _line20: return line20;
      case _s8: return s8;
      case _stairwayUp: return stairwayUp;
      case _line30: return line30;
      case _queueLine: return queueLine;
      case _servicePoint: return servicePoint;
      case _servicePoint3: return servicePoint3;
      case _servicePoint4: return servicePoint4;
      case _servicePoint5: return servicePoint5;
      case _servicesWC: return servicesWC;
      case _polyline5: return polyline5;
      case _polyline6: return polyline6;
      case _polyline7: return polyline7;
      case _polyline8: return polyline8;
      case _polyline9: return polyline9;
      case _polyline10: return polyline10;
      case _polyline11: return polyline11;
      case _polyline12: return polyline12;
      case _polyline13: return polyline13;
      case _polyline16: return polyline16;
      case _table6: return table6;
      case _polyline17: return polyline17;
      case _polyline18: return polyline18;
      case _polyline20: return polyline20;
      case _polyline21: return polyline21;
      case _polyline22: return polyline22;
      case _polyline24: return polyline24;
      case _polyline25: return polyline25;
      case _polyline26: return polyline26;
      case _polyline27: return polyline27;
      case _polyline28: return polyline28;
      case _polyline29: return polyline29;
      case _polyline30: return polyline30;
      case _polyline31: return polyline31;
      case _polyline38: return polyline38;
      case _polyline39: return polyline39;
      case _wall: return wall;
      case _seat7: return seat7;
      case _seat8: return seat8;
      case _seat9: return seat9;
      case _seat10: return seat10;
      case _seat11: return seat11;
      case _seat12: return seat12;
      case _seat13: return seat13;
      case _seat14: return seat14;
      case _seat15: return seat15;
      case _seat16: return seat16;
      case _seat17: return seat17;
      case _seat18: return seat18;
      case _seat19: return seat19;
      case _seat20: return seat20;
      case _seat21: return seat21;
      case _seat22: return seat22;
      case _seat0: return seat0;
      case _seat23: return seat23;
      case _seat1: return seat1;
      case _seat2: return seat2;
      case _seat3: return seat3;
      case _seat4: return seat4;
      case _seat5: return seat5;
      case _seat6: return seat6;
      case _workArea: return workArea;
      case _table16: return table16;
      case _table15: return table15;
      case _table0: return table0;
      case _table23: return table23;
      case _table4: return table4;
      case _table5: return table5;
      case _table2: return table2;
      case _table3: return table3;
      case _table1: return table1;
      case _table7: return table7;
      case _table8: return table8;
      case _table9: return table9;
      case _table10: return table10;
      case _table11: return table11;
      case _table12: return table12;
      case _table13: return table13;
      case _table14: return table14;
      case _table17: return table17;
      case _table18: return table18;
      case _table19: return table19;
      case _table20: return table20;
      case _table21: return table21;
      case _table22: return table22;
      case _area1: return area1;
      case _area2: return area2;
      case _area4: return area4;
      case _ex2: return ex2;
      case _ex1: return ex1;
      case _office: return office;
      case _s1: return s1;
      case _s3_1: return s3_1;
      case _s5: return s5;
      case _s4: return s4;
      case _s2: return s2;
      case _s6: return s6;
      case _s7: return s7;
      case _s3_3: return s3_3;
      case _polyline23: return polyline23;
      case _s3_2: return s3_2;
      case _area1_1: return area1_1;
      case _area1_2: return area1_2;
      case _office1: return office1;
      case _s3_4: return s3_4;
      case _s3_5: return s3_5;
      case _area4_1: return area4_1;
      case _area4_2: return area4_2;
      case _out: return out;
      case _line21: return line21;
      case _attractor: return attractor;
      case _attractor1: return attractor1;
      case _attractor2: return attractor2;
      case _attractor3: return attractor3;
      case _attractor4: return attractor4;
      case _attractor5: return attractor5;
      case _attractor6: return attractor6;
      case _attractor7: return attractor7;
      case _attractor8: return attractor8;
      case _attractor9: return attractor9;
      case _attractor10: return attractor10;
      case _attractor11: return attractor11;
      case _attractor12: return attractor12;
      case _attractor13: return attractor13;
      case _attractor14: return attractor14;
      case _attractor15: return attractor15;
      case _attractor16: return attractor16;
      case _attractor17: return attractor17;
      case _attractor18: return attractor18;
      case _attractor19: return attractor19;
      case _attractor20: return attractor20;
      case _attractor21: return attractor21;
      case _attractor22: return attractor22;
      case _attractor23: return attractor23;
      case _attractor24: return attractor24;
      case _attractor25: return attractor25;
      case _attractor26: return attractor26;
      case _attractor27: return attractor27;
      case _attractor28: return attractor28;
      case _attractor29: return attractor29;
      case _attractor30: return attractor30;
      case _attractor31: return attractor31;
      case _attractor32: return attractor32;
      case _attractor33: return attractor33;
      case _attractor34: return attractor34;
      case _attractor35: return attractor35;
      case _attractor36: return attractor36;
      case _attractor37: return attractor37;
      case _attractor38: return attractor38;
      case _attractor39: return attractor39;
      case _attractor40: return attractor40;
      case _attractor41: return attractor41;
      case _attractor42: return attractor42;
      case _attractor43: return attractor43;
      case _attractor44: return attractor44;
      case _attractor45: return attractor45;
      case _attractor46: return attractor46;
      case _attractor47: return attractor47;
      case _attractor48: return attractor48;
      case _attractor49: return attractor49;
      case _attractor50: return attractor50;
      case _attractor51: return attractor51;
      case _attractor52: return attractor52;
      case _attractor53: return attractor53;
      case _attractor54: return attractor54;
      case _attractor55: return attractor55;
      case _attractor56: return attractor56;
      case _attractor57: return attractor57;
      case _attractor58: return attractor58;
      case _attractor59: return attractor59;
      case _attractor60: return attractor60;
      case _attractor61: return attractor61;
      case _attractor62: return attractor62;
      case _attractor63: return attractor63;
      case _attractor64: return attractor64;
      case _attractor65: return attractor65;
      case _attractor66: return attractor66;
      case _attractor67: return attractor67;
      case _attractor68: return attractor68;
      case _attractor69: return attractor69;
      case _attractor70: return attractor70;
      case _attractor71: return attractor71;
      case _cafeteria: return cafeteria;
      case _stairwayDown: return stairwayDown;
      case _polyline32: return polyline32;
      case _polyline33: return polyline33;
      case _polyline34: return polyline34;
      case _polyline36: return polyline36;
      case _polyline37: return polyline37;
      case _oval: return oval;
      case _oval1: return oval1;
      case _oval10: return oval10;
      case _oval11: return oval11;
      case _oval2: return oval2;
      case _oval3: return oval3;
      case _oval4: return oval4;
      case _oval5: return oval5;
      case _oval6: return oval6;
      case _oval7: return oval7;
      case _oval8: return oval8;
      case _oval9: return oval9;
      case _window: return window;
      case _coffee: return coffee;
      case _area3: return area3;
      case _area3_2: return area3_2;
      case _area3_3: return area3_3;
      case _area3_4: return area3_4;
      case _tofloor1: return tofloor1;
      case _area3_5: return area3_5;
      default: return super.getPersistentShape( _shape ); 
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOfShape_xjal( Object _shape ) {
    try {
      if ( _shape == null ) return null;
      String _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, presentation, "presentation" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, icon, "icon" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, checkbox, "checkbox" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, button, "button" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, sliderRange, "sliderRange" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, radioLayoutType, "radioLayoutType" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, radioNetworkType, "radioNetworkType" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, sliderConnectionsPerAgent, "sliderConnectionsPerAgent" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, sliderNeighborLinkProb, "sliderNeighborLinkProb" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, sliderScaleFreeM, "sliderScaleFreeM" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, radio, "radio" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, checkbox1, "checkbox1" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, checkbox2, "checkbox2" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, checkbox4, "checkbox4" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, checkbox5, "checkbox5" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, checkbox6, "checkbox6" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, plot, "plot" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, groupFloor1, "groupFloor1" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, groupDinnerTable, "groupDinnerTable" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, groupFloor2, "groupFloor2" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text2, "text2" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text3, "text3" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, rectangle1, "rectangle1" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline, "polyline" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line, "line" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line1, "line1" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line2, "line2" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line3, "line3" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line4, "line4" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line5, "line5" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line6, "line6" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line7, "line7" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line8, "line8" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line9, "line9" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line10, "line10" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line11, "line11" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line12, "line12" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line13, "line13" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line14, "line14" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line15, "line15" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line16, "line16" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line17, "line17" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line18, "line18" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line19, "line19" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line31, "line31" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line32, "line32" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line33, "line33" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line34, "line34" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line35, "line35" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line36, "line36" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, groupSt1, "groupSt1" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line37, "line37" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line38, "line38" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line39, "line39" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line40, "line40" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line41, "line41" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line42, "line42" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line43, "line43" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line44, "line44" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line45, "line45" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line46, "line46" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line47, "line47" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line48, "line48" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line49, "line49" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line50, "line50" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line51, "line51" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line52, "line52" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, groupSt2, "groupSt2" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, rectangle2, "rectangle2" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, rectangle9, "rectangle9" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line53, "line53" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, textHead, "textHead" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, groupMainMenu, "groupMainMenu" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text4, "text4" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text5, "text5" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, evacuation_presentation, "evacuation_presentation" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text6, "text6" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text7, "text7" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text9, "text9" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text11, "text11" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text12, "text12" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text13, "text13" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line72, "line72" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text14, "text14" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line73, "line73" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text15, "text15" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line85, "line85" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line86, "line86" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text16, "text16" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line87, "line87" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text17, "text17" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text8, "text8" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline2, "polyline2" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text10, "text10" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, group2, "group2" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text20, "text20" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text21, "text21" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text18, "text18" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text22, "text22" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text23, "text23" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text24, "text24" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line22, "line22" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text25, "text25" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line23, "line23" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text26, "text26" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text27, "text27" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text28, "text28" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text29, "text29" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text30, "text30" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, myAgent_presentation, "myAgent_presentation" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text31, "text31" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text32, "text32" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, visitor_presentation, "visitor_presentation" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text33, "text33" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text34, "text34" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text35, "text35" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text38, "text38" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text39, "text39" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text36, "text36" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text40, "text40" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text41, "text41" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text37, "text37" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text42, "text42" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text44, "text44" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, rectangle3, "rectangle3" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text, "text" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text1, "text1" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text45, "text45" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, oval12, "oval12" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, oval13, "oval13" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text46, "text46" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline3, "polyline3" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text43, "text43" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, group4, "group4" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text47, "text47" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, success, "success" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text48, "text48" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text49, "text49" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, oval14, "oval14" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text50, "text50" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text51, "text51" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text52, "text52" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text53, "text53" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text54, "text54" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text55, "text55" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text56, "text56" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, helper_success, "helper_success" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, enter, "enter" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line20, "line20" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, s8, "s8" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, stairwayUp, "stairwayUp" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line30, "line30" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, queueLine, "queueLine" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, servicePoint, "servicePoint" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, servicePoint3, "servicePoint3" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, servicePoint4, "servicePoint4" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, servicePoint5, "servicePoint5" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, servicesWC, "servicesWC" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline5, "polyline5" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline6, "polyline6" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline7, "polyline7" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline8, "polyline8" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline9, "polyline9" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline10, "polyline10" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline11, "polyline11" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline12, "polyline12" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline13, "polyline13" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline16, "polyline16" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, table6, "table6" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline17, "polyline17" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline18, "polyline18" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline20, "polyline20" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline21, "polyline21" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline22, "polyline22" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline24, "polyline24" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline25, "polyline25" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline26, "polyline26" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline27, "polyline27" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline28, "polyline28" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline29, "polyline29" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline30, "polyline30" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline31, "polyline31" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline38, "polyline38" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline39, "polyline39" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, wall, "wall" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, seat7, "seat7" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, seat8, "seat8" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, seat9, "seat9" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, seat10, "seat10" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, seat11, "seat11" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, seat12, "seat12" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, seat13, "seat13" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, seat14, "seat14" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, seat15, "seat15" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, seat16, "seat16" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, seat17, "seat17" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, seat18, "seat18" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, seat19, "seat19" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, seat20, "seat20" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, seat21, "seat21" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, seat22, "seat22" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, seat0, "seat0" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, seat23, "seat23" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, seat1, "seat1" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, seat2, "seat2" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, seat3, "seat3" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, seat4, "seat4" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, seat5, "seat5" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, seat6, "seat6" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, workArea, "workArea" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, table16, "table16" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, table15, "table15" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, table0, "table0" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, table23, "table23" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, table4, "table4" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, table5, "table5" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, table2, "table2" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, table3, "table3" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, table1, "table1" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, table7, "table7" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, table8, "table8" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, table9, "table9" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, table10, "table10" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, table11, "table11" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, table12, "table12" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, table13, "table13" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, table14, "table14" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, table17, "table17" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, table18, "table18" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, table19, "table19" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, table20, "table20" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, table21, "table21" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, table22, "table22" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, area1, "area1" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, area2, "area2" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, area4, "area4" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, ex2, "ex2" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, ex1, "ex1" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, office, "office" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, s1, "s1" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, s3_1, "s3_1" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, s5, "s5" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, s4, "s4" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, s2, "s2" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, s6, "s6" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, s7, "s7" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, s3_3, "s3_3" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline23, "polyline23" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, s3_2, "s3_2" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, area1_1, "area1_1" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, area1_2, "area1_2" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, office1, "office1" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, s3_4, "s3_4" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, s3_5, "s3_5" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, area4_1, "area4_1" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, area4_2, "area4_2" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, out, "out" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line21, "line21" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor, "attractor" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor1, "attractor1" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor2, "attractor2" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor3, "attractor3" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor4, "attractor4" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor5, "attractor5" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor6, "attractor6" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor7, "attractor7" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor8, "attractor8" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor9, "attractor9" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor10, "attractor10" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor11, "attractor11" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor12, "attractor12" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor13, "attractor13" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor14, "attractor14" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor15, "attractor15" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor16, "attractor16" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor17, "attractor17" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor18, "attractor18" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor19, "attractor19" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor20, "attractor20" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor21, "attractor21" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor22, "attractor22" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor23, "attractor23" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor24, "attractor24" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor25, "attractor25" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor26, "attractor26" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor27, "attractor27" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor28, "attractor28" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor29, "attractor29" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor30, "attractor30" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor31, "attractor31" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor32, "attractor32" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor33, "attractor33" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor34, "attractor34" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor35, "attractor35" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor36, "attractor36" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor37, "attractor37" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor38, "attractor38" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor39, "attractor39" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor40, "attractor40" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor41, "attractor41" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor42, "attractor42" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor43, "attractor43" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor44, "attractor44" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor45, "attractor45" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor46, "attractor46" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor47, "attractor47" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor48, "attractor48" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor49, "attractor49" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor50, "attractor50" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor51, "attractor51" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor52, "attractor52" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor53, "attractor53" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor54, "attractor54" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor55, "attractor55" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor56, "attractor56" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor57, "attractor57" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor58, "attractor58" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor59, "attractor59" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor60, "attractor60" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor61, "attractor61" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor62, "attractor62" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor63, "attractor63" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor64, "attractor64" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor65, "attractor65" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor66, "attractor66" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor67, "attractor67" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor68, "attractor68" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor69, "attractor69" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor70, "attractor70" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, attractor71, "attractor71" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, cafeteria, "cafeteria" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, stairwayDown, "stairwayDown" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline32, "polyline32" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline33, "polyline33" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline34, "polyline34" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline36, "polyline36" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline37, "polyline37" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, oval, "oval" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, oval1, "oval1" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, oval10, "oval10" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, oval11, "oval11" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, oval2, "oval2" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, oval3, "oval3" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, oval4, "oval4" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, oval5, "oval5" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, oval6, "oval6" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, oval7, "oval7" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, oval8, "oval8" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, oval9, "oval9" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, window, "window" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, coffee, "coffee" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, area3, "area3" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, area3_2, "area3_2" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, area3_3, "area3_3" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, area3_4, "area3_4" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, tofloor1, "tofloor1" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, area3_5, "area3_5" ); if (_name_xjal != null) return _name_xjal;
    } catch (Exception e) {
      return null;
    }
    return super.getNameOfShape_xjal( _shape );
  }
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector12_pointsX_xjal = {
    280,  280, 710, 1120 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector12_pointsY_xjal = {
    -220,-130, -130, -60 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector6_pointsX_xjal = {
    350,  380 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector6_pointsY_xjal = {
    -230,-230 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector13_pointsX_xjal = {
    480,  480, 1120 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector13_pointsY_xjal = {
    -200,-130, -60 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector35_pointsX_xjal = {
    250,  250, 990, 990, 1120 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector35_pointsY_xjal = {
    -60,-30, -30, -130, -60 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector1_pointsX_xjal = {
    490,  550 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector1_pointsY_xjal = {
    -210,-210 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector41_pointsX_xjal = {
    350,  960 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector41_pointsY_xjal = {
    -190,-170 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector23_pointsX_xjal = {
    260,  310 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector23_pointsY_xjal = {
    -70,-70 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector16_pointsX_xjal = {
    320,  830 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector16_pointsY_xjal = {
    -60,-60 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector32_pointsX_xjal = {
    860,  860, 990, 1010, 1120 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector32_pointsY_xjal = {
    -50,-30, -30, -110, -60 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector39_pointsX_xjal = {
    350,  860 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector39_pointsY_xjal = {
    -170,-190 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector31_pointsX_xjal = {
    870,  910 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector31_pointsY_xjal = {
    -60,-60 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector18_pointsX_xjal = {
    580,  580, 1120 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector18_pointsY_xjal = {
    -200,-130, -60 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector42_pointsX_xjal = {
    990,  990, 1120 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector42_pointsY_xjal = {
    -160,-130, -60 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector43_pointsX_xjal = {
    890,  890, 1120 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector43_pointsY_xjal = {
    -180,-130, -60 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector4_pointsX_xjal = {
    350,  380, 450 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector4_pointsY_xjal = {
    -210,-210, -210 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector34_pointsX_xjal = {
    680,  680, 1120 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector34_pointsY_xjal = {
    -200,-130, -60 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector17_pointsX_xjal = {
    290,  330 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector17_pointsY_xjal = {
    -230,-230 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector19_pointsX_xjal = {
    20,  100 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector19_pointsY_xjal = {
    -70,-70 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector_pointsX_xjal = {
    590,  650 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector_pointsY_xjal = {
    -210,-210 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector5_pointsX_xjal = {
    330,  380, 380, 380, 450 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector5_pointsY_xjal = {
    -70,-70, -161, -210, -210 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector9_pointsX_xjal = {
    760,  800, 800, 830 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector9_pointsY_xjal = {
    -200,-200, -60, -60 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector11_pointsX_xjal = {
    750,  690 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector11_pointsY_xjal = {
    -210,-210 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector2_pointsX_xjal = {
    120,  170 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector2_pointsY_xjal = {
    -70,-70 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector20_pointsX_xjal = {
    60,  20 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector20_pointsY_xjal = {
    -230,-230 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector21_pointsX_xjal = {
    190,  220 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector21_pointsY_xjal = {
    -70,-70 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector22_pointsX_xjal = {
    180,  1120 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector22_pointsY_xjal = {
    -60,-60 };


  @AnyLogicInternalCodegenAPI
  private void drawModelElements_Connectivity_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawExcelFile( _panel, _g, 1030, -360, 10, 0, "excel", excel );
    }
    if (!_publicOnly) {
      drawExcelFile( _panel, _g, 1110, -370, 10, 0, "excel1", excel1 );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_Events_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawEvent( _panel, _g, 600, -550, 10, 0, "evacuationEnds", evacuationEnds );
    }
    if (!_publicOnly) {
      drawEvent( _panel, _g, 460, -400, 10, 0, "closeCafeteria", closeCafeteria );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_Schedules_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawSchedule( _panel, _g, 280, -440, 10, 0, "visitorsArrivalRate", visitorsArrivalRate );
    }
    if (!_publicOnly) {
      drawSchedule( _panel, _g, 232, -323, 10, 0, "WorkerArrivalRate1", WorkerArrivalRate1 );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_DynamicEvents_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawDynamicEvent( _panel, _g, -590, 1390, 10, 0, "ChangeNumberOfAgents", ChangeNumberOfAgents.class );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_Parameters_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawParameter( _panel, _g, 460, -520, 10, 0, "alarmTime", alarmTime, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 280, -460, 10, 0, "visitorArrivalMultiplier", visitorArrivalMultiplier, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 460, -500, 10, 0, "addExit", addExit, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 280, -420, 10, 0, "workerArrivalRate", workerArrivalRate, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 610, -500, 10, 0, "addExit1", addExit1, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 630, -460, 10, 0, "active_dynamic", active_dynamic, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 660, -400, 10, 0, "safe_exit", safe_exit, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 270, -390, 10, 0, "newvisitorArrivalRate", newvisitorArrivalRate, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 780, -480, 10, 0, "active_predict_help", active_predict_help, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 668, -659, 10, 0, "fire_center", fire_center, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 650, -620, 20, 0, "dis_from_fire", dis_from_fire, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 650, -580, 10, 0, "fire_speed", fire_speed, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 840, -540, 10, 0, "now_time", now_time, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 630, -480, 10, 0, "dynamic_help", dynamic_help, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 650, -600, 10, 0, "connectedag2", connectedag2, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 630, -440, 10, 0, "active_safest", active_safest, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 790, -420, 10, 0, "static_withdoor_sensor", static_withdoor_sensor, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 670, -340, 20, 0, "explosion", explosion, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 510, -820, 10, 0, "floor1_agents", floor1_agents, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 510, -860, 10, 0, "floor2_agents", floor2_agents, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 500, -650, 10, 0, "a1", a1, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 493, -625, 10, 0, "a2", a2, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 513, -685, 10, 0, "a3", a3, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 453, -685, 10, 0, "a4", a4, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 900, -610, 10, 0, "coffee_counter", coffee_counter, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 830, -580, 10, 0, "total_beforealarm", total_beforealarm, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 400, -690, 10, 0, "as1", as1, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 400, -660, 10, 0, "as3_2", as3_2, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 350, -720, 10, 0, "a3_4", a3_4, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 550, -690, 10, 0, "a1_1", a1_1, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 430, -730, 10, 0, "a3_2", a3_2, 0 );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_PlainVariables_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 460, -460, 10, 0, "alarmBegining", alarmBegining, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 460, -480, 10, 0, "alarm", alarm, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 460, -440, 10, 0, "alarmEnding", alarmEnding, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 460, -360, 10, 0, "cafeteriaOpen", cafeteriaOpen, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 460, -320, 10, 0, "visitorCount", visitorCount, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, -590, 1290, 10, 0, "connectionRange", connectionRange, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, -590, 1260, 10, 0, "connectionsPerAgent", connectionsPerAgent, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, -590, 1360, 10, 0, "scaleFreeM", scaleFreeM, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, -570, 1440, 10, 0, "neighborLinkProbability", neighborLinkProbability, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 720, -510, 10, 0, "finish", finish, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 965, -412, 10, 0, "finish1", finish1, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 980, -500, 10, 0, "floor_num_main", floor_num_main, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, -140, 740, 10, 0, "radius", radius, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, -160, 680, 10, 0, "radius2", radius2, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, -110, 800, 10, 0, "dead", dead, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, -80, 840, 10, 0, "injured", injured, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 50, -370, 10, 0, "ten_percent", ten_percent, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 130, -610, 10, 0, "block", block, false );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_CollectionVariables_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawCollection( _panel, _g, 460, -342, 10, 0, "workTables", workTables );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_Functions_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawFunction( _panel, _g, 280, -540, 10, 0, "getPeopleInsideCount");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, 280, -520, 10, 0, "getEvacuationTime");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, 280, -350, 10, 0, "timeToString");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, -590, 1410, 10, 0, "refreshNetwork");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, -590, 1320, 10, 0, "setNumberOfAgents");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, 280, -610, 10, 0, "firealarmfunc");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, 1020, -530, 10, 0, "getsuccess_rate");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, 650, -370, 10, 0, "timeToString2");
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_DataElements_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawDataset( _panel, _g, 460, -420, 15, 0, "evacuationStart", evacuationStart );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_Outputs_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawOutput( _panel, _g, 460, -300, 15, 0, "evacTime", evacTime );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_EmbeddeObjects_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    // Embedded object "evacuation"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 1080 , -100 , 28, 4, "evacuation", this.evacuation );
    }
    // Embedded object "pedSink"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 230 , -30 , 140, -220, "pedSink", this.pedSink );
    }
    // Embedded object "pedGoToStairs"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, -80 , 230 , 285, -330, "pedGoToStairs", this.pedGoToStairs );
    }
    // Embedded object "selectOutput"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 250 , -120 , 26, 37, null, this.selectOutput );
    }
    // Embedded object "visitorSource"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, -180 , 230 , 155, -330, "visitorSource", this.visitorSource );
    }
    // Embedded object "pedEat"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 300 , 40 , 250, -280, "pedEat", this.pedEat );
    }
    // Embedded object "pedGoToExit"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 530 , 240 , 290, -335, "pedGoToExit", this.pedGoToExit );
    }
    // Embedded object "pedExit"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 760 , 140 , 175, -205, "pedExit", this.pedExit );
    }
    // Embedded object "pedSmoke"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 610 , 60 , 247, -281, "pedSmoke", this.pedSmoke );
    }
    // Embedded object "pedWC"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 730 , 130 , 225, -330, "pedWC", this.pedWC );
    }
    // Embedded object "pedSelectOutput"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 120 , 220 , 165, -464, null, this.pedSelectOutput );
    }
    // Embedded object "pedAreaStairwayUp"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 70 , -450 , 30, 10, "pedAreaStairwayUp", this.pedAreaStairwayUp );
    }
    // Embedded object "pedConfiguration"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 60 , -540 , 40, 10, "pedConfiguration", this.pedConfiguration );
    }
    // Embedded object "pedAreaStairwayDown"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 70 , -420 , 30, 10, "pedAreaStairwayDown", this.pedAreaStairwayDown );
    }
    // Embedded object "pedWork"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 0 , 20 , 245, -280, "pedWork", this.pedWork );
    }
    // Embedded object "hold"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 50 , -120 , 45, 20, null, this.hold );
    }
    // Embedded object "pedGoToCafeteria"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 150 , 90 , 265, -330, "pedGoToCafeteria", this.pedGoToCafeteria );
    }
    // Embedded object "pedGoToWork"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 350 , 90 , 280, -330, "pedGoToWork", this.pedGoToWork );
    }
    // Embedded object "selectOutput1"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 690 , -260 , 30, 20, null, this.selectOutput1 );
    }
    // Embedded object "myAgent"
    if (!_publicOnly) {
      drawEmbeddedObjectModelDefault( _panel, _g, -110 , 900 , -45, -35, "myAgent", this.myAgent );
    }
    // Embedded object "visitor"
    if (!_publicOnly) {
      drawEmbeddedObjectModelDefault( _panel, _g, 1150 , -180 , -30, -35, "visitor", this.visitor );
    }
    // Embedded object "visitorSource1"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, -180 , 70 , 155, -330, "visitorSource1", this.visitorSource1 );
    }
    // Embedded object "hold1"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 10 , -280 , 45, 20, null, this.hold1 );
    }
    // Embedded object "selectOutput2"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 110 , -120 , 26, 37, null, this.selectOutput2 );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_Connectors_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector12_pointsX_xjal, _connector12_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector6_pointsX_xjal, _connector6_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector13_pointsX_xjal, _connector13_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector35_pointsX_xjal, _connector35_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector1_pointsX_xjal, _connector1_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector41_pointsX_xjal, _connector41_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector23_pointsX_xjal, _connector23_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector16_pointsX_xjal, _connector16_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector32_pointsX_xjal, _connector32_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector39_pointsX_xjal, _connector39_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector31_pointsX_xjal, _connector31_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector18_pointsX_xjal, _connector18_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector42_pointsX_xjal, _connector42_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector43_pointsX_xjal, _connector43_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector4_pointsX_xjal, _connector4_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector34_pointsX_xjal, _connector34_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector17_pointsX_xjal, _connector17_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector19_pointsX_xjal, _connector19_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector_pointsX_xjal, _connector_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector5_pointsX_xjal, _connector5_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector9_pointsX_xjal, _connector9_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector11_pointsX_xjal, _connector11_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector2_pointsX_xjal, _connector2_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector20_pointsX_xjal, _connector20_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector21_pointsX_xjal, _connector21_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector22_pointsX_xjal, _connector22_pointsY_xjal, false );
      }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_AgentLinks_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (_publicOnly) { return; }
      drawLinkToAgent( _panel, _g, 90, -640, 10, 0, "connections", true, connections );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void drawModelElements( Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
  	super.drawModelElements( _panel, _g, _publicOnly, true );
    drawModelElements_Connectivity_xjal( _panel, _g, _publicOnly, _isSuperClass );
    drawModelElements_Events_xjal( _panel, _g, _publicOnly, _isSuperClass );
    drawModelElements_Schedules_xjal( _panel, _g, _publicOnly, _isSuperClass );
    drawModelElements_DynamicEvents_xjal( _panel, _g, _publicOnly, _isSuperClass );
    drawModelElements_Parameters_xjal( _panel, _g, _publicOnly, _isSuperClass );
    drawModelElements_PlainVariables_xjal( _panel, _g, _publicOnly, _isSuperClass );
    drawModelElements_CollectionVariables_xjal( _panel, _g, _publicOnly, _isSuperClass );
    drawModelElements_Functions_xjal( _panel, _g, _publicOnly, _isSuperClass );
    drawModelElements_DataElements_xjal( _panel, _g, _publicOnly, _isSuperClass );
    drawModelElements_Outputs_xjal( _panel, _g, _publicOnly, _isSuperClass );
    drawModelElements_EmbeddeObjects_xjal( _panel, _g, _publicOnly, _isSuperClass );
    drawModelElements_Connectors_xjal( _panel, _g, _publicOnly, _isSuperClass );
    drawModelElements_AgentLinks_xjal( _panel, _g, _publicOnly, _isSuperClass );
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_EmbeddedObjects_xjal( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if ( evacuation.onClickIconAt( _x - 1080, _y - -100, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "evacuation" );
      } else {
        _panel.addInspect( _x, _y, this, "evacuation" );
      }
      return true;
    }
    if ( pedSink.onClickIconAt( _x - 230, _y - -30, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedSink" );
      } else {
        _panel.addInspect( _x, _y, this, "pedSink" );
      }
      return true;
    }
    if ( pedGoToStairs.onClickIconAt( _x - -80, _y - 230, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedGoToStairs" );
      } else {
        _panel.addInspect( _x, _y, this, "pedGoToStairs" );
      }
      return true;
    }
    if ( selectOutput.onClickIconAt( _x - 250, _y - -120, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "selectOutput" );
      } else {
        _panel.addInspect( _x, _y, this, "selectOutput" );
      }
      return true;
    }
    if ( visitorSource.onClickIconAt( _x - -180, _y - 230, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "visitorSource" );
      } else {
        _panel.addInspect( _x, _y, this, "visitorSource" );
      }
      return true;
    }
    if ( pedEat.onClickIconAt( _x - 300, _y - 40, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedEat" );
      } else {
        _panel.addInspect( _x, _y, this, "pedEat" );
      }
      return true;
    }
    if ( pedGoToExit.onClickIconAt( _x - 530, _y - 240, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedGoToExit" );
      } else {
        _panel.addInspect( _x, _y, this, "pedGoToExit" );
      }
      return true;
    }
    if ( pedExit.onClickIconAt( _x - 760, _y - 140, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedExit" );
      } else {
        _panel.addInspect( _x, _y, this, "pedExit" );
      }
      return true;
    }
    if ( pedSmoke.onClickIconAt( _x - 610, _y - 60, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedSmoke" );
      } else {
        _panel.addInspect( _x, _y, this, "pedSmoke" );
      }
      return true;
    }
    if ( pedWC.onClickIconAt( _x - 730, _y - 130, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedWC" );
      } else {
        _panel.addInspect( _x, _y, this, "pedWC" );
      }
      return true;
    }
    if ( pedSelectOutput.onClickIconAt( _x - 120, _y - 220, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedSelectOutput" );
      } else {
        _panel.addInspect( _x, _y, this, "pedSelectOutput" );
      }
      return true;
    }
    if ( pedAreaStairwayUp.onClickIconAt( _x - 70, _y - -450, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedAreaStairwayUp" );
      } else {
        _panel.addInspect( _x, _y, this, "pedAreaStairwayUp" );
      }
      return true;
    }
    if ( pedConfiguration.onClickIconAt( _x - 60, _y - -540, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedConfiguration" );
      } else {
        _panel.addInspect( _x, _y, this, "pedConfiguration" );
      }
      return true;
    }
    if ( pedAreaStairwayDown.onClickIconAt( _x - 70, _y - -420, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedAreaStairwayDown" );
      } else {
        _panel.addInspect( _x, _y, this, "pedAreaStairwayDown" );
      }
      return true;
    }
    if ( pedWork.onClickIconAt( _x - 0, _y - 20, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedWork" );
      } else {
        _panel.addInspect( _x, _y, this, "pedWork" );
      }
      return true;
    }
    if ( hold.onClickIconAt( _x - 50, _y - -120, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "hold" );
      } else {
        _panel.addInspect( _x, _y, this, "hold" );
      }
      return true;
    }
    if ( pedGoToCafeteria.onClickIconAt( _x - 150, _y - 90, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedGoToCafeteria" );
      } else {
        _panel.addInspect( _x, _y, this, "pedGoToCafeteria" );
      }
      return true;
    }
    if ( pedGoToWork.onClickIconAt( _x - 350, _y - 90, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedGoToWork" );
      } else {
        _panel.addInspect( _x, _y, this, "pedGoToWork" );
      }
      return true;
    }
    if ( selectOutput1.onClickIconAt( _x - 690, _y - -260, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "selectOutput1" );
      } else {
        _panel.addInspect( _x, _y, this, "selectOutput1" );
      }
      return true;
    }
    if ( !myAgent.isEmpty() && modelElementContains(_x, _y, -110, 900) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( -110, 900, this, "myAgent" );
      } else {
        _panel.addInspect( -110, 900, this, "myAgent" );
      }
      return true;
    }
    if ( !visitor.isEmpty() && modelElementContains(_x, _y, 1150, -180) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( 1150, -180, this, "visitor" );
      } else {
        _panel.addInspect( 1150, -180, this, "visitor" );
      }
      return true;
    }
    if ( visitorSource1.onClickIconAt( _x - -180, _y - 70, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "visitorSource1" );
      } else {
        _panel.addInspect( _x, _y, this, "visitorSource1" );
      }
      return true;
    }
    if ( hold1.onClickIconAt( _x - 10, _y - -280, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "hold1" );
      } else {
        _panel.addInspect( _x, _y, this, "hold1" );
      }
      return true;
    }
    if ( selectOutput2.onClickIconAt( _x - 110, _y - -120, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "selectOutput2" );
      } else {
        _panel.addInspect( _x, _y, this, "selectOutput2" );
      }
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_AgentLinks_xjal( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if ( modelElementContains(_x, _y, 90, -640) ) {
        _panel.addInspect_xjal( 90, -640, this, "connections", Panel.INSPECT_CONNECTIONS_xjal );
      return true;
    }
    return false;
  }


  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_Connectivity_xjal( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if( !_publicOnly && modelElementContains(_x, _y, 1030, -360) ) {
      _panel.addInspect( 1030, -360, this, "excel" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 1110, -370) ) {
      _panel.addInspect( 1110, -370, this, "excel1" ); 
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_Parameters_xjal( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if( !_publicOnly && modelElementContains(_x, _y, 460, -520) ) {
      _panel.addInspect( 460, -520, this, "alarmTime" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 280, -460) ) {
      _panel.addInspect( 280, -460, this, "visitorArrivalMultiplier" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 460, -500) ) {
      _panel.addInspect( 460, -500, this, "addExit" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 280, -420) ) {
      _panel.addInspect( 280, -420, this, "workerArrivalRate" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 610, -500) ) {
      _panel.addInspect( 610, -500, this, "addExit1" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 630, -460) ) {
      _panel.addInspect( 630, -460, this, "active_dynamic" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 660, -400) ) {
      _panel.addInspect( 660, -400, this, "safe_exit" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 270, -390) ) {
      _panel.addInspect( 270, -390, this, "newvisitorArrivalRate" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 780, -480) ) {
      _panel.addInspect( 780, -480, this, "active_predict_help" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 668, -659) ) {
      _panel.addInspect( 668, -659, this, "fire_center" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 650, -620) ) {
      _panel.addInspect( 650, -620, this, "dis_from_fire" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 650, -580) ) {
      _panel.addInspect( 650, -580, this, "fire_speed" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 840, -540) ) {
      _panel.addInspect( 840, -540, this, "now_time" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 630, -480) ) {
      _panel.addInspect( 630, -480, this, "dynamic_help" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 650, -600) ) {
      _panel.addInspect( 650, -600, this, "connectedag2" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 630, -440) ) {
      _panel.addInspect( 630, -440, this, "active_safest" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 790, -420) ) {
      _panel.addInspect( 790, -420, this, "static_withdoor_sensor" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 670, -340) ) {
      _panel.addInspect( 670, -340, this, "explosion" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 510, -820) ) {
      _panel.addInspect( 510, -820, this, "floor1_agents" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 510, -860) ) {
      _panel.addInspect( 510, -860, this, "floor2_agents" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 500, -650) ) {
      _panel.addInspect( 500, -650, this, "a1" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 493, -625) ) {
      _panel.addInspect( 493, -625, this, "a2" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 513, -685) ) {
      _panel.addInspect( 513, -685, this, "a3" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 453, -685) ) {
      _panel.addInspect( 453, -685, this, "a4" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 900, -610) ) {
      _panel.addInspect( 900, -610, this, "coffee_counter" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 830, -580) ) {
      _panel.addInspect( 830, -580, this, "total_beforealarm" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 400, -690) ) {
      _panel.addInspect( 400, -690, this, "as1" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 400, -660) ) {
      _panel.addInspect( 400, -660, this, "as3_2" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 350, -720) ) {
      _panel.addInspect( 350, -720, this, "a3_4" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 550, -690) ) {
      _panel.addInspect( 550, -690, this, "a1_1" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 430, -730) ) {
      _panel.addInspect( 430, -730, this, "a3_2" ); 
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_PlainVariables_xjal( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if( !_publicOnly && modelElementContains(_x, _y, 460, -460) ) {
      _panel.addInspect( 460, -460, this, "alarmBegining" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 460, -480) ) {
      _panel.addInspect( 460, -480, this, "alarm" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 460, -440) ) {
      _panel.addInspect( 460, -440, this, "alarmEnding" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 460, -360) ) {
      _panel.addInspect( 460, -360, this, "cafeteriaOpen" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 460, -320) ) {
      _panel.addInspect( 460, -320, this, "visitorCount" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -590, 1290) ) {
      _panel.addInspect( -590, 1290, this, "connectionRange" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -590, 1260) ) {
      _panel.addInspect( -590, 1260, this, "connectionsPerAgent" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -590, 1360) ) {
      _panel.addInspect( -590, 1360, this, "scaleFreeM" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -570, 1440) ) {
      _panel.addInspect( -570, 1440, this, "neighborLinkProbability" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 720, -510) ) {
      _panel.addInspect( 720, -510, this, "finish" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 965, -412) ) {
      _panel.addInspect( 965, -412, this, "finish1" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 980, -500) ) {
      _panel.addInspect( 980, -500, this, "floor_num_main" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -140, 740) ) {
      _panel.addInspect( -140, 740, this, "radius" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -160, 680) ) {
      _panel.addInspect( -160, 680, this, "radius2" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -110, 800) ) {
      _panel.addInspect( -110, 800, this, "dead" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -80, 840) ) {
      _panel.addInspect( -80, 840, this, "injured" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 50, -370) ) {
      _panel.addInspect( 50, -370, this, "ten_percent" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 130, -610) ) {
      _panel.addInspect( 130, -610, this, "block" ); 
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_CollectionVariables_xjal( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if( !_publicOnly && modelElementContains(_x, _y, 460, -342) ) {
      _panel.addInspect( 460, -342, this, "workTables" ); 
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_Events_xjal( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if( !_publicOnly && modelElementContains(_x, _y, 600, -550) ) {
      _panel.addInspect( 600, -550, this, "evacuationEnds" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 460, -400) ) {
      _panel.addInspect( 460, -400, this, "closeCafeteria" ); 
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_Schedules_xjal( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if( !_publicOnly && modelElementContains(_x, _y, 280, -440) ) {
      _panel.addInspect( 280, -440, this, "visitorsArrivalRate" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 232, -323) ) {
      _panel.addInspect( 232, -323, this, "WorkerArrivalRate1" ); 
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_DataElements_xjal( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if( !_publicOnly && modelElementContains(_x, _y, 460, -420) ) {
      _panel.addInspect( 460, -420, this, "evacuationStart" ); 
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_Outputs_xjal( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if( !_publicOnly && modelElementContains(_x, _y, 460, -300) ) {
      _panel.addInspect( 460, -300, this, "evacTime" ); 
      return true;
    }
    return false;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onClickModelAt( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if ( onClickModelAt_EmbeddedObjects_xjal( _panel, _x, _y, _clickCount, _publicOnly, _isSuperClass ) ) { return true; }
    if ( onClickModelAt_AgentLinks_xjal( _panel, _x, _y, _clickCount, _publicOnly, _isSuperClass ) ) { return true; }
    if ( onClickModelAt_Connectivity_xjal( _panel, _x, _y, _clickCount, _publicOnly, _isSuperClass ) ) { return true; }
    if ( onClickModelAt_Parameters_xjal( _panel, _x, _y, _clickCount, _publicOnly, _isSuperClass ) ) { return true; }
    if ( onClickModelAt_PlainVariables_xjal( _panel, _x, _y, _clickCount, _publicOnly, _isSuperClass ) ) { return true; }
    if ( onClickModelAt_CollectionVariables_xjal( _panel, _x, _y, _clickCount, _publicOnly, _isSuperClass ) ) { return true; }
    if ( onClickModelAt_Events_xjal( _panel, _x, _y, _clickCount, _publicOnly, _isSuperClass ) ) { return true; }
    if ( onClickModelAt_Schedules_xjal( _panel, _x, _y, _clickCount, _publicOnly, _isSuperClass ) ) { return true; }
    if ( onClickModelAt_DataElements_xjal( _panel, _x, _y, _clickCount, _publicOnly, _isSuperClass ) ) { return true; }
    if ( onClickModelAt_Outputs_xjal( _panel, _x, _y, _clickCount, _publicOnly, _isSuperClass ) ) { return true; }
    return super.onClickModelAt( _panel, _x, _y, _clickCount, _publicOnly, true );
  }



  @Override
  @AnyLogicInternalCodegenAPI
  public void onArrival() {
    super.onArrival();
    
 
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void onStep() {
    super.onStep();
    
 
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void onBeforeStep() {
    super.onBeforeStep();
    
 
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void onEnterFlowchartBlock(Agent oldBlock, Agent block) {
    super.onEnterFlowchartBlock( oldBlock, block );
    
 
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void onExitFlowchartBlock(Agent block) {
    super.onExitFlowchartBlock(block);
    
 
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void onSeizeResource(Agent unit) {
    super.onSeizeResource(unit);
    
 
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void onReleaseResource(Agent unit) {
    super.onReleaseResource(unit);
    
 
  }

  /**
   * Constructor
   */
  public Main( Engine engine, Agent owner, AgentList<? extends Main> ownerPopulation ) {
    super( engine, owner, ownerPopulation );
    instantiateBaseStructureThis_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void onOwnerChanged_xjal() {
    super.onOwnerChanged_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void instantiateBaseStructure_xjal() {
    super.instantiateBaseStructure_xjal();
    instantiateBaseStructureThis_xjal();
  }
  
  @AnyLogicInternalCodegenAPI
  private void instantiateBaseStructureThis_xjal() {
    evacuation = instantiate_evacuation_xjal();
    pedSink = instantiate_pedSink_xjal();
    pedGoToStairs = instantiate_pedGoToStairs_xjal();
    selectOutput = instantiate_selectOutput_xjal();
    visitorSource = instantiate_visitorSource_xjal();
    pedEat = instantiate_pedEat_xjal();
    pedGoToExit = instantiate_pedGoToExit_xjal();
    pedExit = instantiate_pedExit_xjal();
    pedSmoke = instantiate_pedSmoke_xjal();
    pedWC = instantiate_pedWC_xjal();
    pedSelectOutput = instantiate_pedSelectOutput_xjal();
    pedGoToTable = instantiate_pedGoToTable_xjal();
    pedAreaStairwayUp = instantiate_pedAreaStairwayUp_xjal();
    pedConfiguration = instantiate_pedConfiguration_xjal();
    pedAreaStairwayDown = instantiate_pedAreaStairwayDown_xjal();
    pedWork = instantiate_pedWork_xjal();
    hold = instantiate_hold_xjal();
    pedGoToCafeteria = instantiate_pedGoToCafeteria_xjal();
    pedGoToWork = instantiate_pedGoToWork_xjal();
    selectOutput1 = instantiate_selectOutput1_xjal();
    visitorSource1 = instantiate_visitorSource1_xjal();
    hold1 = instantiate_hold1_xjal();
    selectOutput2 = instantiate_selectOutput2_xjal();
    setupReferences_xjal();
    excel.readFile();
    excel1.readFile();
  }
  
  @AnyLogicInternalCodegenAPI
  private void setupReferences_xjal() {
  }
  
  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public Main() {
  }
  
  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public Main( double alarmTime, double visitorArrivalMultiplier, boolean addExit, double workerArrivalRate, boolean addExit1, boolean active_dynamic, TargetLine safe_exit, double newvisitorArrivalRate, boolean active_predict_help, MyAgent fire_center, double[] dis_from_fire, double fire_speed, double now_time, boolean dynamic_help, MyAgent[] connectedag2, boolean active_safest, boolean static_withdoor_sensor, boolean explosion, MyAgent[] floor1_agents, MyAgent[] floor2_agents, boolean a1, boolean a2, boolean a3, boolean a4, int coffee_counter, long total_beforealarm, boolean as1, boolean as3_2, boolean a3_4, boolean a1_1, boolean a3_2 ) {
    markParametersAreSet();
    this.alarmTime = alarmTime;
    this.visitorArrivalMultiplier = visitorArrivalMultiplier;
    this.addExit = addExit;
    this.workerArrivalRate = workerArrivalRate;
    this.addExit1 = addExit1;
    this.active_dynamic = active_dynamic;
    this.safe_exit = safe_exit;
    this.newvisitorArrivalRate = newvisitorArrivalRate;
    this.active_predict_help = active_predict_help;
    this.fire_center = fire_center;
    this.dis_from_fire = dis_from_fire;
    this.fire_speed = fire_speed;
    this.now_time = now_time;
    this.dynamic_help = dynamic_help;
    this.connectedag2 = connectedag2;
    this.active_safest = active_safest;
    this.static_withdoor_sensor = static_withdoor_sensor;
    this.explosion = explosion;
    this.floor1_agents = floor1_agents;
    this.floor2_agents = floor2_agents;
    this.a1 = a1;
    this.a2 = a2;
    this.a3 = a3;
    this.a4 = a4;
    this.coffee_counter = coffee_counter;
    this.total_beforealarm = total_beforealarm;
    this.as1 = as1;
    this.as3_2 = as3_2;
    this.a3_4 = a3_4;
    this.a1_1 = a1_1;
    this.a3_2 = a3_2;
  }
  
  /**
   * Creating embedded object instances
   */
  @AnyLogicInternalCodegenAPI
  private void instantiatePopulations_xjal() {
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Creating embedded object instances
    instantiatePopulations_xjal();
    // Assigning initial values for plain variables
    setupPlainVariables_Main_xjal();
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
    presentation = new ShapeTopLevelPresentationGroup( Main.this, true, 0, 0, 0, 0 , groupFloor1, groupFloor2, text2, text3, rectangle1, polyline, groupSt1, groupSt2, groupMainMenu, text4, text5, evacuation_presentation, text6, text7, text9, text11, text12, text13, line72, text14, line73, text15, line85, line86, text16, line87, text17, text8, group2, text20, text21, enter, line20, s8, stairwayUp, line30, servicesWC, polyline5, polyline6, polyline7, polyline8, polyline9, polyline10, polyline11, polyline12, polyline13, polyline16, table6, polyline17, polyline18, polyline20, polyline21, polyline22, polyline24, polyline25, polyline26, polyline27, polyline28, polyline29, polyline30, polyline31, polyline38, polyline39, wall, workArea, table16, table15, table0, table23, table4, table5, table2, table3, table1, table7, table8, table9, table10, table11, table12, table13, table14, table17, table18, table19, table20, table21, table22, area1, area2, area4, ex2, ex1, office, s1, s3_1, s5, s4, s2, s6, s7, s3_3, polyline23, s3_2, area1_1, area1_2, office1, s3_4, s3_5, area4_1, area4_2, out, line21, cafeteria, stairwayDown, polyline32, polyline33, polyline34, polyline36, polyline37, oval, oval1, oval10, oval11, oval2, oval3, oval4, oval5, oval6, oval7, oval8, oval9, window, coffee, area3, area3_2, area3_3, area3_4, tofloor1, area3_5, text18, text22, text23, text24, line22, text25, line23, text26, text27, text28, text29, text30, myAgent_presentation, text31, text32, visitor_presentation, text33, text34, text35, text38, text39, text36, text40, text41, text37, text42, text44, rectangle3, text, text1, text45, oval12, oval13, text46, group4, text47, success, text48, text49, oval14, text50, text51, text52, text53, text54, text55, text56, helper_success, checkbox, button, sliderRange, radioLayoutType, radioNetworkType, sliderConnectionsPerAgent, sliderNeighborLinkProb, sliderScaleFreeM, radio, checkbox1, checkbox2, checkbox4, checkbox5, checkbox6, plot );
	_initialize_firstGround_xjal();
	_initialize_secondGround_xjal();
    // Creating contents for replicated shapes
    visitor_presentation.createShapes();
    myAgent_presentation.createShapes();
    addAll( workTables, new Attractor[] 
{ seat0, seat1, seat2, seat3, seat4, seat5, seat6, seat7, seat8, seat9, seat10, seat11, seat12, seat13, seat14, seat15, seat16, seat17, seat18, seat19, seat20, seat21, seat22, seat23 } 
    );
    // Creating embedded object instances
    instantiatePopulations_xjal();
    icon = new ShapeModelElementsGroup( Main.this, getElementProperty( "evacuation.Main.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
    icon.setIconOffsets( 0.0, 0.0 );
    // Environments setup
    {
      double _x_xjal = 
1000 
;
      double _y_xjal = 
620 
;
      double _z_xjal = 
0 
;
      setupSpace( _x_xjal, _y_xjal, _z_xjal );
    }
    disableSteps();
    setNetworkUserDefined();
    setLayoutType( LAYOUT_USER_DEFINED );
    // Creating non-replicated embedded objects
    setupParameters_evacuation_xjal( evacuation );
    create_evacuation_xjal( evacuation );
    setupParameters_pedSink_xjal( pedSink );
    create_pedSink_xjal( pedSink );
    setupParameters_pedGoToStairs_xjal( pedGoToStairs );
    create_pedGoToStairs_xjal( pedGoToStairs );
    setupParameters_selectOutput_xjal( selectOutput );
    create_selectOutput_xjal( selectOutput );
    setupParameters_visitorSource_xjal( visitorSource );
    create_visitorSource_xjal( visitorSource );
    setupParameters_pedEat_xjal( pedEat );
    create_pedEat_xjal( pedEat );
    setupParameters_pedGoToExit_xjal( pedGoToExit );
    create_pedGoToExit_xjal( pedGoToExit );
    setupParameters_pedExit_xjal( pedExit );
    create_pedExit_xjal( pedExit );
    setupParameters_pedSmoke_xjal( pedSmoke );
    create_pedSmoke_xjal( pedSmoke );
    setupParameters_pedWC_xjal( pedWC );
    create_pedWC_xjal( pedWC );
    setupParameters_pedSelectOutput_xjal( pedSelectOutput );
    create_pedSelectOutput_xjal( pedSelectOutput );
    setupParameters_pedGoToTable_xjal( pedGoToTable );
    create_pedGoToTable_xjal( pedGoToTable );
    setupParameters_pedAreaStairwayUp_xjal( pedAreaStairwayUp );
    create_pedAreaStairwayUp_xjal( pedAreaStairwayUp );
    setupParameters_pedConfiguration_xjal( pedConfiguration );
    create_pedConfiguration_xjal( pedConfiguration );
    setupParameters_pedAreaStairwayDown_xjal( pedAreaStairwayDown );
    create_pedAreaStairwayDown_xjal( pedAreaStairwayDown );
    setupParameters_pedWork_xjal( pedWork );
    create_pedWork_xjal( pedWork );
    setupParameters_hold_xjal( hold );
    create_hold_xjal( hold );
    setupParameters_pedGoToCafeteria_xjal( pedGoToCafeteria );
    create_pedGoToCafeteria_xjal( pedGoToCafeteria );
    setupParameters_pedGoToWork_xjal( pedGoToWork );
    create_pedGoToWork_xjal( pedGoToWork );
    setupParameters_selectOutput1_xjal( selectOutput1 );
    create_selectOutput1_xjal( selectOutput1 );
    setupParameters_visitorSource1_xjal( visitorSource1 );
    create_visitorSource1_xjal( visitorSource1 );
    setupParameters_hold1_xjal( hold1 );
    create_hold1_xjal( hold1 );
    setupParameters_selectOutput2_xjal( selectOutput2 );
    create_selectOutput2_xjal( selectOutput2 );
	 // Port connectors with non-replicated objects
    pedWork.ccl.connect( evacuation.port ); // connector12
    pedGoToTable.ccl.connect( evacuation.port ); // connector15
    pedSelectOutput.out1.connect( pedSink.in ); // connector6
    pedGoToCafeteria.ccl.connect( evacuation.port ); // connector13
    pedGoToStairs.ccl.connect( evacuation.port ); // connector35
    pedGoToCafeteria.out.connect( pedEat.in ); // connector1
    pedSelectOutput.out5.connect( pedGoToTable.in ); // connector7
    pedSelectOutput.out3.connect( pedWC.in ); // connector41
    pedSmoke.out.connect( pedGoToTable.in ); // connector10
    pedWC.out.connect( pedGoToTable.in ); // connector38
    pedGoToStairs.out.connect( selectOutput.in ); // connector23
    selectOutput.outF.connect( pedGoToExit.in ); // connector16
    pedGoToExit.ccl.connect( evacuation.port ); // connector32
    pedSelectOutput.out4.connect( pedSmoke.in ); // connector39
    pedGoToExit.out.connect( pedExit.in ); // connector31
    pedEat.ccl.connect( evacuation.port ); // connector18
    pedWC.ccl.connect( evacuation.port ); // connector42
    pedSmoke.ccl.connect( evacuation.port ); // connector43
    pedSelectOutput.out2.connect( pedGoToCafeteria.in ); // connector4
    pedGoToWork.ccl.connect( evacuation.port ); // connector34
    pedGoToTable.out.connect( pedWork.in ); // connector14
    pedWork.out.connect( pedSelectOutput.in ); // connector17
    visitorSource.out.connect( hold.in ); // connector19
    pedEat.out.connect( pedGoToWork.in ); // connector
    selectOutput1.outT.connect( pedGoToTable.in ); // connector3
    selectOutput.outT.connect( pedGoToCafeteria.in ); // connector5
    selectOutput1.outF.connect( pedGoToExit.in ); // connector9
    selectOutput1.in.connect( pedGoToWork.out ); // connector11
    hold.out.connect( selectOutput2.in ); // connector2
    hold1.out.connect( pedGoToTable.in ); // connector8
    hold1.in.connect( visitorSource1.out ); // connector20
    selectOutput2.outT.connect( pedGoToStairs.in ); // connector21
    selectOutput2.outF.connect( evacuation.port ); // connector22
    // Creating replicated embedded objects
    myAgent.setEnvironment( this );
    myAgent.fillFromTable( new TableInput( this, (java.util.function.Supplier<ResultSet> & Serializable) () -> selectResultSet(
	"SELECT * FROM loc2;"
)), null, true, false );
    visitor.setEnvironment( this );
    for ( int i = 0; i < visitor.size(); i++ ) {
       setupParameters_visitor_xjal( visitor.get(i), i );
       create_visitor_xjal( visitor.get(i), i );
    }
    setupInitialConditions_xjal( Main.class );
    checkbox.setValueToDefault();
    sliderRange.setValueToDefault();
    radioLayoutType.setValueToDefault();
    radioNetworkType.setValueToDefault();
    sliderConnectionsPerAgent.setValueToDefault();
    sliderNeighborLinkProb.setValueToDefault();
    sliderScaleFreeM.setValueToDefault();
    radio.setValueToDefault();
    checkbox1.setValueToDefault();
    checkbox2.setValueToDefault();
    checkbox4.setValueToDefault();
    checkbox5.setValueToDefault();
    checkbox6.setValueToDefault();
  }

  @AnyLogicInternalCodegenAPI
  public void setupExt_xjal(AgentExtension _ext) {
    // Agent properties setup
    if ( _ext instanceof ExtAgentWithSpatialMetrics && _ext instanceof ExtWithSpaceType ) {
      double _value;
      _value = 
10 
;
      ((ExtAgentWithSpatialMetrics) _ext).setSpeed( _value, MPS );
    }
    if ( _ext instanceof ExtAgentWithSpatialMetrics ) {
      ExtAgentWithSpatialMetrics _e = (ExtAgentWithSpatialMetrics) _ext;
      _e.setAutomaticHorizontalRotation( true );
    }
    if ( _ext instanceof ExtAgentContinuous ) {
      ExtAgentContinuous _e = (ExtAgentContinuous) _ext;
      _e.setAutomaticVerticalRotation( false );
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    closeCafeteria.start();
    _plot_autoUpdateEvent_xjal.start();
    _visitorsArrivalRate_Action_xjal.start();
    _WorkerArrivalRate1_Action_xjal.start();
    evacuationEnds.start();
    for (Agent embeddedObject : myAgent){
      embeddedObject.start();
    }
    for (Agent embeddedObject : visitor){
      embeddedObject.start();
    }
    evacuation.start();
    pedSink.start();
    pedGoToStairs.start();
    selectOutput.start();
    visitorSource.start();
    pedEat.start();
    pedGoToExit.start();
    pedExit.start();
    pedSmoke.start();
    pedWC.start();
    pedSelectOutput.start();
    pedGoToTable.start();
    pedAreaStairwayUp.start();
    pedConfiguration.start();
    pedAreaStairwayDown.start();
    pedWork.start();
    hold.start();
    pedGoToCafeteria.start();
    pedGoToWork.start();
    selectOutput1.start();
    visitorSource1.start();
    hold1.start();
    selectOutput2.start();
  }
 
  @AnyLogicInternalCodegenAPI
  public void onStartup() {
    super.onStartup();
    
viewArea.navigateTo();
//myAgent_presentation. 
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_Main_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_Main_xjal() {
    alarmBegining = 
 
;
    alarm = 
false 
;
    alarmEnding = 
0 
;
    cafeteriaOpen = 
true 
;
    visitorCount = 
0 
;
    connectionRange = 
50 
;
    connectionsPerAgent = 
2 
;
    scaleFreeM = 
10 
;
    neighborLinkProbability = 
0.95 
;
    finish = 
false 
;
    finish1 = 
false 
;
    floor_num_main = 
0 
;
    radius = 
6 
;
    radius2 = 
0.01 
;
    dead = 
0 
;
    injured = 
0 
;
    ten_percent = 
0 
;
    block = 
false 
;
  }

  // User API -----------------------------------------------------
  @AnyLogicInternalCodegenAPI
  static LinkToAgentAnimationSettings _connections_commonAnimationSettings_xjal = new LinkToAgentAnimationSettingsImpl( false, black, 1.0, LINE_STYLE_SOLID, ARROW_NONE, 0.0 );

  public LinkToAgentCollection<Agent, Agent> connections = new LinkToAgentStandardImpl<Agent, Agent>(this, _connections_commonAnimationSettings_xjal);
  @Override
  public LinkToAgentCollection<? extends Agent, ? extends Agent> getLinkToAgentStandard_xjal() {
    return connections;
  }
  @Override
  @AnyLogicInternalCodegenAPI
  public void onReceive( Object _msg_xjal, Agent _sender_xjal ) {
    super.onReceive( _msg_xjal, _sender_xjal );
    
Object  msg = (Object) _msg_xjal;
    Agent sender = _sender_xjal;
    
 
  }



  @AnyLogicInternalCodegenAPI
  public void drawLinksToAgents(boolean _underAgents_xjal, LinkToAgentAnimator _animator_xjal) {
    super.drawLinksToAgents(_underAgents_xjal, _animator_xjal);
    if ( _underAgents_xjal ) {
      _animator_xjal.drawLink( this, connections, true, true );
    }
  }

  public List<Object> getEmbeddedObjects() {
    List<Object> list = super.getEmbeddedObjects();
    if (list == null) {
      list = new LinkedList<Object>();
    }
    list.add( evacuation );
    list.add( pedSink );
    list.add( pedGoToStairs );
    list.add( selectOutput );
    list.add( visitorSource );
    list.add( pedEat );
    list.add( pedGoToExit );
    list.add( pedExit );
    list.add( pedSmoke );
    list.add( pedWC );
    list.add( pedSelectOutput );
    list.add( pedGoToTable );
    list.add( pedAreaStairwayUp );
    list.add( pedConfiguration );
    list.add( pedAreaStairwayDown );
    list.add( pedWork );
    list.add( hold );
    list.add( pedGoToCafeteria );
    list.add( pedGoToWork );
    list.add( selectOutput1 );
    list.add( myAgent );
    list.add( visitor );
    list.add( visitorSource1 );
    list.add( hold1 );
    list.add( selectOutput2 );
    return list;
  }

  public AgentList<? extends Main> getPopulation() {
    return (AgentList<? extends Main>) super.getPopulation();
  }

  public List<? extends Main> agentsInRange( double distance ) {
    return (List<? extends Main>) super.agentsInRange( distance );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean isLoggingToDB(LoggingType loggingType) {
    return false;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean isLoggingToDB(EventOriginator _e) {
    if ( _e == _plot_autoUpdateEvent_xjal ) return false;
    return super.isLoggingToDB( _e );
  }

  // Reaction on changes -------------------------------------
  public void onChange() {
    super.onChange();
    evacuationEnds.onChange();
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    closeCafeteria.onDestroy();
    _plot_autoUpdateEvent_xjal.onDestroy();
    _visitorsArrivalRate_Action_xjal.onDestroy();
    _WorkerArrivalRate1_Action_xjal.onDestroy();
    evacuationEnds.onDestroy();
    evacuation.onDestroy();
    pedSink.onDestroy();
    pedGoToStairs.onDestroy();
    selectOutput.onDestroy();
    visitorSource.onDestroy();
    pedEat.onDestroy();
    pedGoToExit.onDestroy();
    pedExit.onDestroy();
    pedSmoke.onDestroy();
    pedWC.onDestroy();
    pedSelectOutput.onDestroy();
    pedGoToTable.onDestroy();
    pedAreaStairwayUp.onDestroy();
    pedConfiguration.onDestroy();
    pedAreaStairwayDown.onDestroy();
    pedWork.onDestroy();
    hold.onDestroy();
    pedGoToCafeteria.onDestroy();
    pedGoToWork.onDestroy();
    selectOutput1.onDestroy();
    for (Agent _item : myAgent) {
      _item.onDestroy();
    }
    for (Agent _item : visitor) {
      _item.onDestroy();
    }
    visitorSource1.onDestroy();
    hold1.onDestroy();
    selectOutput2.onDestroy();
    // On destroy code
    
 
    excel.writeFile();
    excel1.writeFile();
    servicesWC.onDestroy();
  // Analysis Data Elements
    _plot_expression0_dataSet_xjal.destroyUpdater_xjal();
    _plot_expression1_dataSet_xjal.destroyUpdater_xjal();
    evacuationStart.destroyUpdater_xjal();
    logToDB( evacuationStart, "evacuationStart" );
    logToDB( _plot_expression0_dataSet_xjal, "plot : success_rate" );
    logToDB( _plot_expression1_dataSet_xjal, "plot :  PeopleInside" );
    super.onDestroy();
  }

  @AnyLogicInternalCodegenAPI
  @Override
  public void doFinish() {
    update_evacTime();
    evacuation.doFinish();
    super.doFinish();
    pedSink.doFinish();
    super.doFinish();
    pedGoToStairs.doFinish();
    super.doFinish();
    selectOutput.doFinish();
    super.doFinish();
    visitorSource.doFinish();
    super.doFinish();
    pedEat.doFinish();
    super.doFinish();
    pedGoToExit.doFinish();
    super.doFinish();
    pedExit.doFinish();
    super.doFinish();
    pedSmoke.doFinish();
    super.doFinish();
    pedWC.doFinish();
    super.doFinish();
    pedSelectOutput.doFinish();
    super.doFinish();
    pedGoToTable.doFinish();
    super.doFinish();
    pedAreaStairwayUp.doFinish();
    super.doFinish();
    pedConfiguration.doFinish();
    super.doFinish();
    pedAreaStairwayDown.doFinish();
    super.doFinish();
    pedWork.doFinish();
    super.doFinish();
    hold.doFinish();
    super.doFinish();
    pedGoToCafeteria.doFinish();
    super.doFinish();
    pedGoToWork.doFinish();
    super.doFinish();
    selectOutput1.doFinish();
    super.doFinish();
    for (Agent _item : myAgent) {
      _item.doFinish();
    }
    super.doFinish();
    for (Agent _item : visitor) {
      _item.doFinish();
    }
    super.doFinish();
    visitorSource1.doFinish();
    super.doFinish();
    hold1.doFinish();
    super.doFinish();
    selectOutput2.doFinish();
    super.doFinish();
  }

  // Additional class code

 
  // End of additional class code


}
