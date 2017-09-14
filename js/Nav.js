import React, { Component } from 'react'
import {
   Platform, BackHandler, ToastAndroid
} from 'react-native'
import { StackNavigator, TabNavigator, DrawerNavigator } from 'react-navigation'
import HomeScreen from './pages/HomePage'
import MineScreen from './pages/MinePage'

let lastBackPressed = 0
export default class Nav extends Component {

    componentWillMount() {
        BackHandler.addEventListener('hardwareBackPress', () => this._onBackHandler())
    }

    componentUnWillMount() {
        BackHandler.removeEventListener('hardwareBackPress', () => this._onBackHandler())
    }

    _onBackHandler() {
        let now = new Date().getTime();
        if(now - lastBackPressed < 2500) {
            return false;
        }
        lastBackPressed = now;
        ToastAndroid.show('再点击一次退出应用', ToastAndroid.SHORT);
        return true;
    }

    render() {
        return (
            <Navigator />
        );
    }
}

const Navigator = TabNavigator({
    Home:{screen:HomeScreen},
    Mine:{screen:MineScreen}
})
