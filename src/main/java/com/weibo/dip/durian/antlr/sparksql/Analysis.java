package com.weibo.dip.durian.antlr.sparksql;

/** @author yurun */
public class Analysis {
  private String sql;

  private boolean isQuery;
  private boolean isUse;
  private boolean isCreateDatabase;
  private boolean isSetDatabaseProperties;
  private boolean isDropDatabase;
  private boolean isCreateTable;
  private boolean isCreateHiveTable;
  private boolean isCreateTableLike;
  private boolean isAnalyze;
  private boolean isAddTableColumns;
  private boolean isRenameTable;
  private boolean isSetTableProperties;
  private boolean isUnsetTableProperties;
  private boolean isChangeColumn;
  private boolean isSetTableSerDe;
  private boolean isAddTablePartition;
  private boolean isRenameTablePartition;
  private boolean isDropTablePartitions;
  private boolean isSetTableLocation;
  private boolean isSetTablePartitions;
  private boolean isRecoverPartitions;
  private boolean isDropTable;
  private boolean isCreateView;
  private boolean isCreateTempViewUsing;
  private boolean isAlterViewQuery;
  private boolean isCreateFunction;
  private boolean isDropFunction;
  private boolean isExplain;
  private boolean isShowTables;
  private boolean isShowTable;
  private boolean isShowDatabases;
  private boolean isShowTblProperties;
  private boolean isShowColumns;
  private boolean isShowPartitions;
  private boolean isShowFunctions;
  private boolean isShowCreateTable;
  private boolean isDescribeFunction;
  private boolean isDescribeDatabase;
  private boolean isDescribeTable;
  private boolean isRefreshResource;
  private boolean isCacheTable;
  private boolean isUncacheTable;
  private boolean isClearCache;
  private boolean isLoadData;
  private boolean isTruncateTable;
  private boolean isRepairTable;
  private boolean isManageResource;
  private boolean isFailNativeCommand;
  private boolean isSetConfiguration;
  private boolean isResetConfiguration;

  public String getSql() {
    return sql;
  }

  public void setSql(String sql) {
    this.sql = sql;
  }

  public boolean isQuery() {
    return isQuery;
  }

  public void setQuery(boolean query) {
    isQuery = query;
  }

  public boolean isUse() {
    return isUse;
  }

  public void setUse(boolean use) {
    isUse = use;
  }

  public boolean isCreateDatabase() {
    return isCreateDatabase;
  }

  public void setCreateDatabase(boolean createDatabase) {
    isCreateDatabase = createDatabase;
  }

  public boolean isSetDatabaseProperties() {
    return isSetDatabaseProperties;
  }

  public void setSetDatabaseProperties(boolean setDatabaseProperties) {
    isSetDatabaseProperties = setDatabaseProperties;
  }

  public boolean isDropDatabase() {
    return isDropDatabase;
  }

  public void setDropDatabase(boolean dropDatabase) {
    isDropDatabase = dropDatabase;
  }

  public boolean isCreateTable() {
    return isCreateTable;
  }

  public void setCreateTable(boolean createTable) {
    isCreateTable = createTable;
  }

  public boolean isCreateHiveTable() {
    return isCreateHiveTable;
  }

  public void setCreateHiveTable(boolean createHiveTable) {
    isCreateHiveTable = createHiveTable;
  }

  public boolean isCreateTableLike() {
    return isCreateTableLike;
  }

  public void setCreateTableLike(boolean createTableLike) {
    isCreateTableLike = createTableLike;
  }

  public boolean isAnalyze() {
    return isAnalyze;
  }

  public void setAnalyze(boolean analyze) {
    isAnalyze = analyze;
  }

  public boolean isAddTableColumns() {
    return isAddTableColumns;
  }

  public void setAddTableColumns(boolean addTableColumns) {
    isAddTableColumns = addTableColumns;
  }

  public boolean isRenameTable() {
    return isRenameTable;
  }

  public void setRenameTable(boolean renameTable) {
    isRenameTable = renameTable;
  }

  public boolean isSetTableProperties() {
    return isSetTableProperties;
  }

  public void setSetTableProperties(boolean setTableProperties) {
    isSetTableProperties = setTableProperties;
  }

  public boolean isUnsetTableProperties() {
    return isUnsetTableProperties;
  }

  public void setUnsetTableProperties(boolean unsetTableProperties) {
    isUnsetTableProperties = unsetTableProperties;
  }

  public boolean isChangeColumn() {
    return isChangeColumn;
  }

  public void setChangeColumn(boolean changeColumn) {
    isChangeColumn = changeColumn;
  }

  public boolean isSetTableSerDe() {
    return isSetTableSerDe;
  }

  public void setSetTableSerDe(boolean setTableSerDe) {
    isSetTableSerDe = setTableSerDe;
  }

  public boolean isAddTablePartition() {
    return isAddTablePartition;
  }

  public void setAddTablePartition(boolean addTablePartition) {
    isAddTablePartition = addTablePartition;
  }

  public boolean isRenameTablePartition() {
    return isRenameTablePartition;
  }

  public void setRenameTablePartition(boolean renameTablePartition) {
    isRenameTablePartition = renameTablePartition;
  }

  public boolean isDropTablePartitions() {
    return isDropTablePartitions;
  }

  public void setDropTablePartitions(boolean dropTablePartitions) {
    isDropTablePartitions = dropTablePartitions;
  }

  public boolean isSetTableLocation() {
    return isSetTableLocation;
  }

  public void setSetTableLocation(boolean setTableLocation) {
    isSetTableLocation = setTableLocation;
  }

  public boolean isSetTablePartitions() {
    return isSetTablePartitions;
  }

  public void setSetTablePartitions(boolean setTablePartitions) {
    isSetTablePartitions = setTablePartitions;
  }

  public boolean isRecoverPartitions() {
    return isRecoverPartitions;
  }

  public void setRecoverPartitions(boolean recoverPartitions) {
    isRecoverPartitions = recoverPartitions;
  }

  public boolean isDropTable() {
    return isDropTable;
  }

  public void setDropTable(boolean dropTable) {
    isDropTable = dropTable;
  }

  public boolean isCreateView() {
    return isCreateView;
  }

  public void setCreateView(boolean createView) {
    isCreateView = createView;
  }

  public boolean isCreateTempViewUsing() {
    return isCreateTempViewUsing;
  }

  public void setCreateTempViewUsing(boolean createTempViewUsing) {
    isCreateTempViewUsing = createTempViewUsing;
  }

  public boolean isAlterViewQuery() {
    return isAlterViewQuery;
  }

  public void setAlterViewQuery(boolean alterViewQuery) {
    isAlterViewQuery = alterViewQuery;
  }

  public boolean isCreateFunction() {
    return isCreateFunction;
  }

  public void setCreateFunction(boolean createFunction) {
    isCreateFunction = createFunction;
  }

  public boolean isDropFunction() {
    return isDropFunction;
  }

  public void setDropFunction(boolean dropFunction) {
    isDropFunction = dropFunction;
  }

  public boolean isExplain() {
    return isExplain;
  }

  public void setExplain(boolean explain) {
    isExplain = explain;
  }

  public boolean isShowTables() {
    return isShowTables;
  }

  public void setShowTables(boolean showTables) {
    isShowTables = showTables;
  }

  public boolean isShowTable() {
    return isShowTable;
  }

  public void setShowTable(boolean showTable) {
    isShowTable = showTable;
  }

  public boolean isShowDatabases() {
    return isShowDatabases;
  }

  public void setShowDatabases(boolean showDatabases) {
    isShowDatabases = showDatabases;
  }

  public boolean isShowTblProperties() {
    return isShowTblProperties;
  }

  public void setShowTblProperties(boolean showTblProperties) {
    isShowTblProperties = showTblProperties;
  }

  public boolean isShowColumns() {
    return isShowColumns;
  }

  public void setShowColumns(boolean showColumns) {
    isShowColumns = showColumns;
  }

  public boolean isShowPartitions() {
    return isShowPartitions;
  }

  public void setShowPartitions(boolean showPartitions) {
    isShowPartitions = showPartitions;
  }

  public boolean isShowFunctions() {
    return isShowFunctions;
  }

  public void setShowFunctions(boolean showFunctions) {
    isShowFunctions = showFunctions;
  }

  public boolean isShowCreateTable() {
    return isShowCreateTable;
  }

  public void setShowCreateTable(boolean showCreateTable) {
    isShowCreateTable = showCreateTable;
  }

  public boolean isDescribeFunction() {
    return isDescribeFunction;
  }

  public void setDescribeFunction(boolean describeFunction) {
    isDescribeFunction = describeFunction;
  }

  public boolean isDescribeDatabase() {
    return isDescribeDatabase;
  }

  public void setDescribeDatabase(boolean describeDatabase) {
    isDescribeDatabase = describeDatabase;
  }

  public boolean isDescribeTable() {
    return isDescribeTable;
  }

  public void setDescribeTable(boolean describeTable) {
    isDescribeTable = describeTable;
  }

  public boolean isRefreshResource() {
    return isRefreshResource;
  }

  public void setRefreshResource(boolean refreshResource) {
    isRefreshResource = refreshResource;
  }

  public boolean isCacheTable() {
    return isCacheTable;
  }

  public void setCacheTable(boolean cacheTable) {
    isCacheTable = cacheTable;
  }

  public boolean isUncacheTable() {
    return isUncacheTable;
  }

  public void setUncacheTable(boolean uncacheTable) {
    isUncacheTable = uncacheTable;
  }

  public boolean isClearCache() {
    return isClearCache;
  }

  public void setClearCache(boolean clearCache) {
    isClearCache = clearCache;
  }

  public boolean isLoadData() {
    return isLoadData;
  }

  public void setLoadData(boolean loadData) {
    isLoadData = loadData;
  }

  public boolean isTruncateTable() {
    return isTruncateTable;
  }

  public void setTruncateTable(boolean truncateTable) {
    isTruncateTable = truncateTable;
  }

  public boolean isRepairTable() {
    return isRepairTable;
  }

  public void setRepairTable(boolean repairTable) {
    isRepairTable = repairTable;
  }

  public boolean isManageResource() {
    return isManageResource;
  }

  public void setManageResource(boolean manageResource) {
    isManageResource = manageResource;
  }

  public boolean isFailNativeCommand() {
    return isFailNativeCommand;
  }

  public void setFailNativeCommand(boolean failNativeCommand) {
    isFailNativeCommand = failNativeCommand;
  }

  public boolean isSetConfiguration() {
    return isSetConfiguration;
  }

  public void setSetConfiguration(boolean setConfiguration) {
    isSetConfiguration = setConfiguration;
  }

  public boolean isResetConfiguration() {
    return isResetConfiguration;
  }

  public void setResetConfiguration(boolean resetConfiguration) {
    isResetConfiguration = resetConfiguration;
  }
}
