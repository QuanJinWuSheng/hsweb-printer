/*
 *  Copyright (c) 2015.  meicanyun.com Corporation Limited.
 *  All rights reserved.
 *
 *  This software is the confidential and proprietary information of
 *  meicanyun Company. ("Confidential Information").  You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into
 *  with meicanyun.com.
 */

package org.hsweb.printer.fx.dtos;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.Serializable;
import java.util.function.BiConsumer;

/**
 * Created by xiong on 2017-07-10.
 */
public class PubPropertyDTO implements Serializable {
    private VBox propertyPubName;
    private VBox propertyPubValue;
    private ObservableList<Node> pubNames;
    private ObservableList<Node> pubValues;
    public PubPropertyDTO(VBox propertyPubName, VBox propertyPubValue) {
        this.propertyPubName = propertyPubName;
        this.propertyPubValue = propertyPubValue;
        pubNames=propertyPubName.getChildren();
        pubValues=propertyPubValue.getChildren();

    }

    public void clear(){
        pubNames.clear();
        pubValues.clear();
    }

    public void add(Node  pubName,Node pubValue){
        pubNames.add(pubName);
        pubValues.add(pubValue);
    }
    public void add(String  pubName, String pubValue, BiConsumer<String,TextField> stringConsumer){
        Text tableColumn=new Text(pubName);

        TextField tableColumn2=new TextField();
        tableColumn2.setText(pubValue);
        tableColumn2.setEditable(true);
        tableColumn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stringConsumer.accept(tableColumn2.getText(),tableColumn2);
            }
        });

        this.add(tableColumn,tableColumn2);
    }
}