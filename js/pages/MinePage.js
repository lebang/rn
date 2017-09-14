import React, { Component } from 'react'
import {
   Text, View, StyleSheet
} from 'react-native'

export default class MinePage extends Component {
    static navigationOptions = {
        title:'我的'
    }

    render() {
        return (
            <View style={styles.container}>
                <Text style={styles.btnStyle} onPress={() => this._skip()}> 返回上一页 </Text>
            </View>
        )
    }

    _skip() {
         this.props.navigation.goBack();
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#ffffff'
    },
    btnStyle: {
        height: 40,
        width: 160,
        borderColor: 'gray',
        borderWidth: 1,
        fontSize: 26,
        textAlign: 'center'
    }
})