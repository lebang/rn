import React, { Component } from 'react'
import { View, TextInput, Text, StyleSheet, Dimensions } from 'react-native'

let totalWidth = Dimensions.get('window').width
let leftStartPoint = totalWidth * 0.1
let componentWidth = totalWidth * 0.8

export default class extends Component {
    constructor(props) {
        super(props)
    }

    render() {
        return(
                <View style={styles.container}>
                    <TextInput style={styles.numberInputStyle} placeholder={'请输入手机号!'} />
                    <Text style={styles.textPromptStyle}>
                        你输入的手机号:
                    </Text>
                    <TextInput style={styles.passwordInputStyle} placeholder={'请输入密码!'} password={true} />
                    <Text style={styles.bigTextPrompt}> 确定 </Text>
                </View>
            )
    }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#ffffff'
  },
  numberInputStyle: {
    top: 20,
    left: leftStartPoint,
    width: componentWidth,
    backgroundColor: 'gray',
    fontSize: 20
  },
  textPromptStyle: {
    top:30,
    left: leftStartPoint,
    width: componentWidth,
    fontSize: 20
  },
  passwordInputStyle: {
    top: 50,
    left: leftStartPoint,
    width: componentWidth,
    backgroundColor: 'gray',
    fontSize: 20
  },
  bigTextPrompt: {
    top: 70,
    left: leftStartPoint,
    width: componentWidth,
    backgroundColor: 'gray',
    color: 'white',
    textAlign: 'center',
    fontSize: 60
  }
})
