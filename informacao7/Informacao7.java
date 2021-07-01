/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pucpr.atp.juan;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 *
 * @author juan.manoel
 */
public class Informacao7 {

    public static class MapInformacao extends Mapper<Object, Text, Text, LongWritable> {

        @Override
        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            try {
                
                String[] fields = value.toString().split(";");
                if (fields.length == 10) {
                   
                    Text keyField = new Text(fields[3]);
                    LongWritable valueMap = new LongWritable(Long.parseLong(fields[6]));

                    context.write(keyField, valueMap);

                }
            } catch (IOException | InterruptedException | NumberFormatException err) {
                System.out.println(err);
            }

        }

    }

    public static class ReduceInformacao extends Reducer<Text, LongWritable, Text, LongWritable> {

        @Override
        public void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
            long i = 0;

            for (LongWritable intvalues : values) {
                i += intvalues.get();
            }

            context.write(key, new LongWritable(i));

        }

    }

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        String pathIn = "/home/Disciplinas/FundamentosBigData/OperacoesComerciais/base_100_mil.csv";
        String pathOut = "/home2/ead2021/SEM1/juan.manoel/Desktop/atp/" + Informacao7.class.getSimpleName();

        if (args.length == 2) {
            pathIn = args[0];
            pathOut = args[1];
        }

        Configuration config = new Configuration();
        Job job = Job.getInstance(config, Informacao7.class.getSimpleName());

        job.setJarByClass(Informacao7.class);
        job.setMapperClass(MapInformacao.class);
        job.setReducerClass(ReduceInformacao.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        FileInputFormat.addInputPath(job, new Path(pathIn));
        FileOutputFormat.setOutputPath(job, new Path(pathOut));

        job.waitForCompletion(true);
    }
    
}
