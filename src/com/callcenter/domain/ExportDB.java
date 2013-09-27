package com.callcenter.domain;



import java.io.File;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class ExportDB
{

    public static void main(String[] args)
    {

        Configuration cfg = new Configuration().configure();

        SchemaExport export = new SchemaExport(cfg);

        export.create(true, true);
    }
}
