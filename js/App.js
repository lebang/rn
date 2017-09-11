import React, { Component } from 'react'
import { View, Text, StyleSheet, FlatList, TouchableHighlight, NativeModules, TextInput } from 'react-native'

let RnInterface = NativeModules.RnInterface;

var flatListData = [{
        key: 'a',
        text: '444'
    },{
        key: 'b',
        text: '333'
    },{
        key: 'c',
        text: '2222'
    },{
        key: 'd',
        text: '111'
    }];

export default class extends Component {
    constructor(props) {
        super(props)
        this.state = {
            TEXT:''
        }
    }
    setText(text){
        this.setState({TEXT: text})
    }

    buttonPressed() {
        NativeModules.RnInterface.HandlerMessage(this.state.TEXT);
    }
    goList() {
        NativeModules.RnInterface.GoListActivity();
    }
    render() {
        return (
           <View style={styles.container}>
               <TextInput
                   style={{height: 40, width: 200, borderColor: 'gray', borderWidth: 1,}}
                   placeholder={'text enter'}
                   onChangeText={(text) => {this.setText(text)}}
                   value={this.state.TEXT}/>
               <Text
                   style={{height: 40, width: 100, borderColor: 'gray', borderWidth: 1, fontSize: 26}}
                   onPress={ () => this.buttonPressed()}> button </Text>
               <Text
                    style={{height: 40, width: 100, borderColor: 'gray', borderWidth: 1, fontSize: 26}}
                    onPress={() => this.goList()}> goList </Text>
           </View>
        )
    }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#ffffff'
  },
  text: {
    fontSize: 20,
    color: '#333333'
  }
})