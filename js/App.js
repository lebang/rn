import React, { Component } from 'react'
import {
    View, Text, StyleSheet,
    FlatList, TouchableHighlight,
    NativeModules, TextInput, Button,
    Platform, BackHandler
} from 'react-native'
import { StackNavigator } from 'react-navigation';
let RnInterface = NativeModules.RnInterface;

class HomeScreen extends Component {
    static navigationOptions = {
        title: 'welcome'
    }

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
        RnInterface.HandlerMessage(this.state.TEXT);
    }
    goList() {
        RnInterface.GoListActivity();
    }

    render() {
        const {navigate} = this.props.navigation;
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
               <Button onPress={() => navigate('Chat')} title="chat with lucy" />
           </View>
        )
    }
}

class ChatScreen extends Component {

    static navigationOptions = {
        title: 'chat with lucy',
    }

    constructor(props) {
        super(props)
    }

    render() {
        return(
            <Text> chat withs lucy </Text>
        )
    }

}

export default App = StackNavigator({
    Home: {screen: HomeScreen},
    Chat: {screen: ChatScreen}
})

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



