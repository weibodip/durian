package com.weibo.dip.durian.antlr.sparksql;

/** @author yurun */
public class SparkSqlVisitor extends SqlBaseBaseVisitor<Void> {
  private Analysis analysis = new Analysis();

  public Analysis getAnalysis() {
    return analysis;
  }

  @Override
  public Void visitStatementDefault(SqlBaseParser.StatementDefaultContext ctx) {
    analysis.setQuery(true);

    return super.visitStatementDefault(ctx);
  }

  @Override
  public Void visitUse(SqlBaseParser.UseContext ctx) {
    analysis.setUse(true);

    return super.visitUse(ctx);
  }

  @Override
  public Void visitCreateDatabase(SqlBaseParser.CreateDatabaseContext ctx) {
    analysis.setCreateDatabase(true);

    return super.visitCreateDatabase(ctx);
  }

  @Override
  public Void visitSetDatabaseProperties(SqlBaseParser.SetDatabasePropertiesContext ctx) {
    analysis.setSetDatabaseProperties(true);

    return super.visitSetDatabaseProperties(ctx);
  }

  @Override
  public Void visitDropDatabase(SqlBaseParser.DropDatabaseContext ctx) {
    analysis.setDropDatabase(true);

    return super.visitDropDatabase(ctx);
  }

  @Override
  public Void visitCreateTable(SqlBaseParser.CreateTableContext ctx) {
    analysis.setCreateTable(true);

    return super.visitCreateTable(ctx);
  }

  @Override
  public Void visitCreateHiveTable(SqlBaseParser.CreateHiveTableContext ctx) {
    analysis.setCreateHiveTable(true);

    return super.visitCreateHiveTable(ctx);
  }

  @Override
  public Void visitCreateTableLike(SqlBaseParser.CreateTableLikeContext ctx) {
    analysis.setCreateTableLike(true);

    return super.visitCreateTableLike(ctx);
  }

  @Override
  public Void visitAnalyze(SqlBaseParser.AnalyzeContext ctx) {
    analysis.setAnalyze(true);

    return super.visitAnalyze(ctx);
  }

  @Override
  public Void visitAddTableColumns(SqlBaseParser.AddTableColumnsContext ctx) {
    analysis.setAddTableColumns(true);

    return super.visitAddTableColumns(ctx);
  }

  @Override
  public Void visitRenameTable(SqlBaseParser.RenameTableContext ctx) {
    analysis.setRenameTable(true);

    return super.visitRenameTable(ctx);
  }

  @Override
  public Void visitSetTableProperties(SqlBaseParser.SetTablePropertiesContext ctx) {
    analysis.setSetTableProperties(true);

    return super.visitSetTableProperties(ctx);
  }

  @Override
  public Void visitUnsetTableProperties(SqlBaseParser.UnsetTablePropertiesContext ctx) {
    analysis.setUnsetTableProperties(true);

    return super.visitUnsetTableProperties(ctx);
  }

  @Override
  public Void visitChangeColumn(SqlBaseParser.ChangeColumnContext ctx) {
    analysis.setChangeColumn(true);

    return super.visitChangeColumn(ctx);
  }

  @Override
  public Void visitSetTableSerDe(SqlBaseParser.SetTableSerDeContext ctx) {
    analysis.setSetTableSerDe(true);

    return super.visitSetTableSerDe(ctx);
  }

  @Override
  public Void visitAddTablePartition(SqlBaseParser.AddTablePartitionContext ctx) {
    analysis.setAddTablePartition(true);

    return super.visitAddTablePartition(ctx);
  }

  @Override
  public Void visitRenameTablePartition(SqlBaseParser.RenameTablePartitionContext ctx) {
    analysis.setRenameTablePartition(true);

    return super.visitRenameTablePartition(ctx);
  }

  @Override
  public Void visitDropTablePartitions(SqlBaseParser.DropTablePartitionsContext ctx) {
    analysis.setDropTablePartitions(true);

    return super.visitDropTablePartitions(ctx);
  }

  @Override
  public Void visitSetTableLocation(SqlBaseParser.SetTableLocationContext ctx) {
    analysis.setSetTableLocation(true);

    return super.visitSetTableLocation(ctx);
  }

  @Override
  public Void visitRecoverPartitions(SqlBaseParser.RecoverPartitionsContext ctx) {
    analysis.setRecoverPartitions(true);

    return super.visitRecoverPartitions(ctx);
  }

  @Override
  public Void visitDropTable(SqlBaseParser.DropTableContext ctx) {
    analysis.setDropTable(true);

    return super.visitDropTable(ctx);
  }

  @Override
  public Void visitCreateView(SqlBaseParser.CreateViewContext ctx) {
    analysis.setCreateView(true);

    return super.visitCreateView(ctx);
  }

  @Override
  public Void visitCreateTempViewUsing(SqlBaseParser.CreateTempViewUsingContext ctx) {
    analysis.setCreateTempViewUsing(true);

    return super.visitCreateTempViewUsing(ctx);
  }

  @Override
  public Void visitAlterViewQuery(SqlBaseParser.AlterViewQueryContext ctx) {
    analysis.setAlterViewQuery(true);

    return super.visitAlterViewQuery(ctx);
  }

  @Override
  public Void visitCreateFunction(SqlBaseParser.CreateFunctionContext ctx) {
    analysis.setCreateFunction(true);

    return super.visitCreateFunction(ctx);
  }

  @Override
  public Void visitDropFunction(SqlBaseParser.DropFunctionContext ctx) {
    analysis.setDropFunction(true);

    return super.visitDropFunction(ctx);
  }

  @Override
  public Void visitExplain(SqlBaseParser.ExplainContext ctx) {
    analysis.setExplain(true);

    return super.visitExplain(ctx);
  }

  @Override
  public Void visitShowTables(SqlBaseParser.ShowTablesContext ctx) {
    analysis.setShowTables(true);

    return super.visitShowTables(ctx);
  }

  @Override
  public Void visitShowTable(SqlBaseParser.ShowTableContext ctx) {
    analysis.setShowTable(true);

    return super.visitShowTable(ctx);
  }

  @Override
  public Void visitShowDatabases(SqlBaseParser.ShowDatabasesContext ctx) {
    analysis.setShowDatabases(true);

    return super.visitShowDatabases(ctx);
  }

  @Override
  public Void visitShowTblProperties(SqlBaseParser.ShowTblPropertiesContext ctx) {
    analysis.setShowTblProperties(true);

    return super.visitShowTblProperties(ctx);
  }

  @Override
  public Void visitShowColumns(SqlBaseParser.ShowColumnsContext ctx) {
    analysis.setShowColumns(true);

    return super.visitShowColumns(ctx);
  }

  @Override
  public Void visitShowPartitions(SqlBaseParser.ShowPartitionsContext ctx) {
    analysis.setShowPartitions(true);

    return super.visitShowPartitions(ctx);
  }

  @Override
  public Void visitShowFunctions(SqlBaseParser.ShowFunctionsContext ctx) {
    analysis.setShowFunctions(true);

    return super.visitShowFunctions(ctx);
  }

  @Override
  public Void visitShowCreateTable(SqlBaseParser.ShowCreateTableContext ctx) {
    analysis.setShowCreateTable(true);

    return super.visitShowCreateTable(ctx);
  }

  @Override
  public Void visitDescribeFunction(SqlBaseParser.DescribeFunctionContext ctx) {
    analysis.setDescribeFunction(true);

    return super.visitDescribeFunction(ctx);
  }

  @Override
  public Void visitDescribeDatabase(SqlBaseParser.DescribeDatabaseContext ctx) {
    analysis.setDescribeDatabase(true);

    return super.visitDescribeDatabase(ctx);
  }

  @Override
  public Void visitDescribeTable(SqlBaseParser.DescribeTableContext ctx) {
    analysis.setDescribeTable(true);

    return super.visitDescribeTable(ctx);
  }

  @Override
  public Void visitRefreshTable(SqlBaseParser.RefreshTableContext ctx) {
    analysis.setRefreshResource(true);

    return super.visitRefreshTable(ctx);
  }

  @Override
  public Void visitRefreshResource(SqlBaseParser.RefreshResourceContext ctx) {
    analysis.setRefreshResource(true);

    return super.visitRefreshResource(ctx);
  }

  @Override
  public Void visitCacheTable(SqlBaseParser.CacheTableContext ctx) {
    analysis.setCacheTable(true);

    return super.visitCacheTable(ctx);
  }

  @Override
  public Void visitUncacheTable(SqlBaseParser.UncacheTableContext ctx) {
    analysis.setUncacheTable(true);

    return super.visitUncacheTable(ctx);
  }

  @Override
  public Void visitClearCache(SqlBaseParser.ClearCacheContext ctx) {
    analysis.setClearCache(true);

    return super.visitClearCache(ctx);
  }

  @Override
  public Void visitLoadData(SqlBaseParser.LoadDataContext ctx) {
    analysis.setLoadData(true);

    return super.visitLoadData(ctx);
  }

  @Override
  public Void visitTruncateTable(SqlBaseParser.TruncateTableContext ctx) {
    analysis.setTruncateTable(true);

    return super.visitTruncateTable(ctx);
  }

  @Override
  public Void visitRepairTable(SqlBaseParser.RepairTableContext ctx) {
    analysis.setRepairTable(true);

    return super.visitRepairTable(ctx);
  }

  @Override
  public Void visitManageResource(SqlBaseParser.ManageResourceContext ctx) {
    analysis.setManageResource(true);

    return super.visitManageResource(ctx);
  }

  @Override
  public Void visitFailNativeCommand(SqlBaseParser.FailNativeCommandContext ctx) {
    analysis.setFailNativeCommand(true);

    return super.visitFailNativeCommand(ctx);
  }

  @Override
  public Void visitSetConfiguration(SqlBaseParser.SetConfigurationContext ctx) {
    analysis.setSetConfiguration(true);

    return super.visitSetConfiguration(ctx);
  }

  @Override
  public Void visitResetConfiguration(SqlBaseParser.ResetConfigurationContext ctx) {
    analysis.setResetConfiguration(true);

    return super.visitResetConfiguration(ctx);
  }
}
