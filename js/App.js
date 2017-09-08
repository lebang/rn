import React, { Component } from 'react'
import { View, Text, StyleSheet, FlatList, TouchableHighlight, NativeModules, TextInput } from 'react-native'

let RnInterface = NativeModules.RnInterface;

var flatListData = [{
        key: 'a',
        text: '444ss'
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
            TEXT:'',
            BTNPRESS:false
        }
    }
    setTEXT(text){
        this.setState({TEXT: text})
    }
    setBTNPRESS(press){
        this.setState({BTNPRESS:press});
    }
    buttonPressed() {
        if (this.state.BTNPRESS){
            NativeModules.RnInterface.HandlerMessage(this.state.TEXT);
        }
    }
    render() {
        return (
           <View style={styles.container}>
                <TextInput
                    style={{height: 40, width: 200, borderColor: 'gray', borderWidth: 1,}}
                    placeholder={'text enter'}
                    onChangeText={(text) => {this.setTEXT(text)}}
                    value={this.state.TEXT}/>
                <Text
                    style={{height: 40, width: 100, borderColor: 'gray', borderWidth: 1, fontSize: 26}}
                    onPress={this.setBTNPRESS(!this.state.BTNPRESS)}> button </Text>
           </View>
        )
    }

//                 <FlatList
//                    data={flatListData}
//                    keyExtractor={this._keyExtractor}
//                    ListHeaderComponent={this.ListHeaderComponent.bind(this)}
//                    renderItem={this.renderItem.bind(this)}
//                />
//                <Text onPress={this.buttonPressed}> button press </Text>

    _keyExtractor = (item, index) => item.key

    ListHeaderComponent() {
        return (
             <Text > header </Text>
        )
    }

    renderItem({item, index}) {
        return (
            <View >
                <Text style={styles.item} onPress={() => this.buttonPressed()}>{item.text}</Text>
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
  txt:{
    width:200,
    height:40
  },
  modal:{
    margin:40,
    alignItems: 'center',
    backgroundColor:'#f00'
  },
  item: {
    padding: 10,
    fontSize: 18,
    height: 44,
  },
  text: {
    fontSize: 20,
    color: '#333333'
  }
})