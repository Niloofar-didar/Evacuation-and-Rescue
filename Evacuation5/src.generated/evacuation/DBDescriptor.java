package evacuation;

import evacuation.tables_al.*;
import com.anylogic.engine.*;
import com.anylogic.engine.database.*;
import com.anylogic.engine.connectivity.*;

import java.util.Arrays;
import java.io.File;
import java.sql.Connection;

/**
 * Descriptors for built-in database tables
 */
@AnyLogicInternalCodegenAPI
public class DBDescriptor implements DBInfo, TableDataImporter, TableDataExporter {

  /**
   * Descriptor for database table 'agent_types_raw_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qagent_types_raw_log agent_types_raw_log = Qagent_types_raw_log.INSTANCE;

  /**
   * Descriptor for database table 'agents_raw_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qagents_raw_log agents_raw_log = Qagents_raw_log.INSTANCE;

  /**
   * Descriptor for database table 'destroyed_agents_raw_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qdestroyed_agents_raw_log destroyed_agents_raw_log = Qdestroyed_agents_raw_log.INSTANCE;

  /**
   * Descriptor for database table 'agent_parameters_raw_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qagent_parameters_raw_log agent_parameters_raw_log = Qagent_parameters_raw_log.INSTANCE;

  /**
   * Descriptor for database table 'agent_type_elements_raw_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qagent_type_elements_raw_log agent_type_elements_raw_log = Qagent_type_elements_raw_log.INSTANCE;

  /**
   * Descriptor for database table 'agent_type_statecharts_raw_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qagent_type_statecharts_raw_log agent_type_statecharts_raw_log = Qagent_type_statecharts_raw_log.INSTANCE;

  /**
   * Descriptor for database table 'agent_elements_raw_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qagent_elements_raw_log agent_elements_raw_log = Qagent_elements_raw_log.INSTANCE;

  /**
   * Descriptor for database table 'trace_raw_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qtrace_raw_log trace_raw_log = Qtrace_raw_log.INSTANCE;

  /**
   * Descriptor for database table 'statechart_states_raw_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qstatechart_states_raw_log statechart_states_raw_log = Qstatechart_states_raw_log.INSTANCE;

  /**
   * Descriptor for database table 'statechart_transitions_raw_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qstatechart_transitions_raw_log statechart_transitions_raw_log = Qstatechart_transitions_raw_log.INSTANCE;

  /**
   * Descriptor for database table 'events_raw_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qevents_raw_log events_raw_log = Qevents_raw_log.INSTANCE;

  /**
   * Descriptor for database table 'agent_movement_raw_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qagent_movement_raw_log agent_movement_raw_log = Qagent_movement_raw_log.INSTANCE;

  /**
   * Descriptor for database table 'agent_messages_raw_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qagent_messages_raw_log agent_messages_raw_log = Qagent_messages_raw_log.INSTANCE;

  /**
   * Descriptor for database table 'flowchart_entries_raw_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qflowchart_entries_raw_log flowchart_entries_raw_log = Qflowchart_entries_raw_log.INSTANCE;

  /**
   * Descriptor for database table 'flowchart_process_states_raw_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qflowchart_process_states_raw_log flowchart_process_states_raw_log = Qflowchart_process_states_raw_log.INSTANCE;

  /**
   * Descriptor for database table 'statistics_raw_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qstatistics_raw_log statistics_raw_log = Qstatistics_raw_log.INSTANCE;

  /**
   * Descriptor for database table 'datasets_raw_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qdatasets_raw_log datasets_raw_log = Qdatasets_raw_log.INSTANCE;

  /**
   * Descriptor for database table 'histograms_raw_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qhistograms_raw_log histograms_raw_log = Qhistograms_raw_log.INSTANCE;

  /**
   * Descriptor for database table 'resource_unit_states_raw_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qresource_unit_states_raw_log resource_unit_states_raw_log = Qresource_unit_states_raw_log.INSTANCE;

  /**
   * Descriptor for database table 'resource_pool_utilization_raw_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qresource_pool_utilization_raw_log resource_pool_utilization_raw_log = Qresource_pool_utilization_raw_log.INSTANCE;

  /**
   * Descriptor for database table 'resource_unit_utilization_raw_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qresource_unit_utilization_raw_log resource_unit_utilization_raw_log = Qresource_unit_utilization_raw_log.INSTANCE;

  /**
   * Descriptor for database table 'fluid_units_raw_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qfluid_units_raw_log fluid_units_raw_log = Qfluid_units_raw_log.INSTANCE;

  /**
   * Descriptor for database table 'fluid_storages_raw_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qfluid_storages_raw_log fluid_storages_raw_log = Qfluid_storages_raw_log.INSTANCE;

  /**
   * Descriptor for database table 'fluid_rates_raw_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qfluid_rates_raw_log fluid_rates_raw_log = Qfluid_rates_raw_log.INSTANCE;

  /**
   * Descriptor for database table 'fluid_utilization_raw_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qfluid_utilization_raw_log fluid_utilization_raw_log = Qfluid_utilization_raw_log.INSTANCE;

  /**
   * Descriptor for database table 'agents_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qagents_log agents_log = Qagents_log.INSTANCE;

  /**
   * Descriptor for database table 'library_blocks_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qlibrary_blocks_log library_blocks_log = Qlibrary_blocks_log.INSTANCE;

  /**
   * Descriptor for database table 'agent_parameters_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qagent_parameters_log agent_parameters_log = Qagent_parameters_log.INSTANCE;

  /**
   * Descriptor for database table 'library_block_parameters_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qlibrary_block_parameters_log library_block_parameters_log = Qlibrary_block_parameters_log.INSTANCE;

  /**
   * Descriptor for database table 'agent_movement_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qagent_movement_log agent_movement_log = Qagent_movement_log.INSTANCE;

  /**
   * Descriptor for database table 'agent_movement_stats_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qagent_movement_stats_log agent_movement_stats_log = Qagent_movement_stats_log.INSTANCE;

  /**
   * Descriptor for database table 'agent_messages_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qagent_messages_log agent_messages_log = Qagent_messages_log.INSTANCE;

  /**
   * Descriptor for database table 'events_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qevents_log events_log = Qevents_log.INSTANCE;

  /**
   * Descriptor for database table 'flowchart_entries_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qflowchart_entries_log flowchart_entries_log = Qflowchart_entries_log.INSTANCE;

  /**
   * Descriptor for database table 'flowchart_process_states_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qflowchart_process_states_log flowchart_process_states_log = Qflowchart_process_states_log.INSTANCE;

  /**
   * Descriptor for database table 'flowchart_stats_time_in_state_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qflowchart_stats_time_in_state_log flowchart_stats_time_in_state_log = Qflowchart_stats_time_in_state_log.INSTANCE;

  /**
   * Descriptor for database table 'resource_unit_states_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qresource_unit_states_log resource_unit_states_log = Qresource_unit_states_log.INSTANCE;

  /**
   * Descriptor for database table 'resource_unit_task_stats_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qresource_unit_task_stats_log resource_unit_task_stats_log = Qresource_unit_task_stats_log.INSTANCE;

  /**
   * Descriptor for database table 'resource_pool_task_stats_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qresource_pool_task_stats_log resource_pool_task_stats_log = Qresource_pool_task_stats_log.INSTANCE;

  /**
   * Descriptor for database table 'resource_pool_utilization_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qresource_pool_utilization_log resource_pool_utilization_log = Qresource_pool_utilization_log.INSTANCE;

  /**
   * Descriptor for database table 'resource_unit_utilization_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qresource_unit_utilization_log resource_unit_utilization_log = Qresource_unit_utilization_log.INSTANCE;

  /**
   * Descriptor for database table 'fluid_units_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qfluid_units_log fluid_units_log = Qfluid_units_log.INSTANCE;

  /**
   * Descriptor for database table 'fluid_storages_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qfluid_storages_log fluid_storages_log = Qfluid_storages_log.INSTANCE;

  /**
   * Descriptor for database table 'fluid_rates_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qfluid_rates_log fluid_rates_log = Qfluid_rates_log.INSTANCE;

  /**
   * Descriptor for database table 'fluid_utilization_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qfluid_utilization_log fluid_utilization_log = Qfluid_utilization_log.INSTANCE;

  /**
   * Descriptor for database table 'statechart_transitions_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qstatechart_transitions_log statechart_transitions_log = Qstatechart_transitions_log.INSTANCE;

  /**
   * Descriptor for database table 'agent_statechart_states_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qagent_statechart_states_log agent_statechart_states_log = Qagent_statechart_states_log.INSTANCE;

  /**
   * Descriptor for database table 'agent_statechart_stats_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qagent_statechart_stats_log agent_statechart_stats_log = Qagent_statechart_stats_log.INSTANCE;

  /**
   * Descriptor for database table 'agent_type_statechart_stats_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qagent_type_statechart_stats_log agent_type_statechart_stats_log = Qagent_type_statechart_stats_log.INSTANCE;

  /**
   * Descriptor for database table 'statistics_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qstatistics_log statistics_log = Qstatistics_log.INSTANCE;

  /**
   * Descriptor for database table 'datasets_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qdatasets_log datasets_log = Qdatasets_log.INSTANCE;

  /**
   * Descriptor for database table 'histograms_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qhistograms_log histograms_log = Qhistograms_log.INSTANCE;

  /**
   * Descriptor for database table 'trace_log'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qtrace_log trace_log = Qtrace_log.INSTANCE;

  /**
   * Descriptor for database table 'sheet1'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qsheet1 sheet1 = Qsheet1.INSTANCE;

  /**
   * Descriptor for database table 'loc'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qloc loc = Qloc.INSTANCE;

  /**
   * Descriptor for database table 'loc2'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qloc2 loc2 = Qloc2.INSTANCE;

  /**
   * Descriptor for database table 'helperrr'.<br>
   * To be used in functions like
   * {@linkplain Utilities#selectFrom(com.mysema.query.types.Expression) selectFrom()}
   */
  public static final Qhelperrr helperrr = Qhelperrr.INSTANCE;

  @AnyLogicInternalCodegenAPI
  public DBDescriptor() {
  }
  
  @Override
  public DatabaseCustomType[] getCustomTypes() {
  	return new DatabaseCustomType[] {
	
  	};
  }
  
  @AnyLogicInternalAPI
  public void importTableDataOnStartup(java.sql.Connection internalDatabaseConnection) throws Exception {
    try (DatabaseDescriptorRegistry r = new DatabaseDescriptorRegistry()) {
      java.sql.Connection cachedSourceConnection;
      cachedSourceConnection = r.getConnection(DatabaseDescriptorFactory.createFileDescriptor( Utilities.findExistingFile("excel.xlsx"), null, ""));
      UtilitiesDatabase.copyDatabaseTable(cachedSourceConnection, internalDatabaseConnection, "\"Sheet1\"", "sheet1");
	}
  }
  
  @AnyLogicInternalAPI
  public void exportTableDataOnFinish(java.sql.Connection internalDatabaseConnection) throws Exception {
  }
}
