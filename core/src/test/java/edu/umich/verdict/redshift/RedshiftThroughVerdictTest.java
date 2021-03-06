package edu.umich.verdict.redshift;

import edu.umich.verdict.VerdictConf;
import edu.umich.verdict.VerdictContext;
import edu.umich.verdict.VerdictJDBCContext;
import edu.umich.verdict.exceptions.VerdictException;

public class RedshiftThroughVerdictTest {

    public static void main(String[] args) throws VerdictException {

        VerdictConf conf = new VerdictConf();
        conf.setDbms("redshift");
        conf.setHost("salat2-verdict.ctkb4oe4rzfm.us-east-1.redshift.amazonaws.com");
        conf.setPort("5439");		
        conf.setDbmsSchema("dev");
        conf.setUser("junhao");
        conf.setPassword("BTzyc1xG");
        conf.set("loglevel", "debug");

        VerdictContext vc = VerdictJDBCContext.from(conf);
//        vc.executeJdbcQuery("select count(*) from tpch1g.customer");
//        vc.executeJdbcQuery("set search_path to tpch1g");
        vc.executeJdbcQuery("set search_path to tpch1g,tpch1g_verdict");
        vc.executeJdbcQuery("create sample of tpch1g.orders");

        vc.destroy();
    }

}
