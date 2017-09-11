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
    }
    buttonPressed(msg) {
        NativeModules.RnInterface.HandlerMessage(msg);
    }
    render() {
        return (
           <View style={styles.container}>
               <FlatList
                  data={flatListData}
                  keyExtractor={this._keyExtractor}
                  ListHeaderComponent={this.ListHeader.bind(this)}
                  renderItem={this.renderItem.bind(this)}
                  ListFooterComponent={this.ListFooter.bind(this)}
                  ItemSeparatorComponent={this.ItemSeparator.bind(this)}
              />
           </View>
        )
    }

    _keyExtractor = (item) => item.key

    ListHeader() {
        return (
             <Text> header </Text>
        )
    }
    ListFooter() {
        return(
            <Text> footer </Text>
        )
    }
    ItemSeparator() {
        return (
            <View style={{height:2,backgroundColor:'yellow'}}/>
        );
    }
    renderItem({item, index}) {
        return (
            <Text style={styles.item} onPress={() => this.buttonPressed(item.text)}>{item.text}</Text>
        )
    }


}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'space-around',
    backgroundColor: '#ffffff'
  },
  item: {
    flex: 1,
    height: 40,
    fontSize: 18,
    textAlign: 'center',
    backgroundColor: '#999999'
  }
})