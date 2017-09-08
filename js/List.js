//'use strict';
//import React, { Component } from 'react'
//import {
//    View,
//    Image,
//    Dimensions,
//    ScrollView,
//    Text,
//    StyleSheet,
//    TouchableOpacity,
//    Button,
//    FlatList,
//    ActivityIndicator,
//    RefreshControl,
//} from 'react-native'
//
//var listData = [{
//        key: 'a',
//        text: '444'
//    },{
//        key: 'b',
//        text: '333'
//    },{
//        key: 'c',
//        text: '2222'
//    },{
//        key: 'd',
//        text: '111'
//    }];
//
//export default class extends Component{
//    constructor(props) {
//        super(props);
//        this.state = { };
//    }
//
//    render() {
////        const { params } = this.props.state;
//        return (
//            <View style={styles.container}>
//                <FlatList
//                    style={styles.title}
//                    data={listData}
//                    ListHeaderComponent={this.ListHeaderComponent.bind(this)}
//                    renderItem={this.renderItem.bind(this)}
//                    keyExtractor={this._keyExtractor}
//                    refreshControl={
//                        <RefreshControl refreshing={true} />
//                    }
//                />
//            </View>
//        )
//    }
//
//    _keyExtractor = (item, index) => item.key; //为给定的item生成一个不重复的key
//
//    componentDidMount() {}
//
//    ListHeaderComponent() { //列表头部
//        return (
//            <DetailsHeadItem titleName="学习" unitName="007" />
//        )
//    }
//
//    renderItem({item, index}) {//列表项
//        return (
//            <TouchableOpacity key={index} activeOpacity={1} onPress={this.clickItem.bind(this, item, index)}>
//                <DetaileRowItem />
//            </TouchableOpacity>
//        )
//    }
//
//
//    renderItemSeparator(){//绘制列表的分割线
//
//    }
//
//    clickItem(item, index) {
//        alert(index)
//    }
//
//    const styles = StyleSheet.create({
//        container: {
//            flex: 1,
//            flexDirection: 'row',
//            justifyContent: 'center',
//            alignItems: 'center',
//            backgroundColor: '#F5FCFF',
//        },
//        title: {
//            fontSize: 15,
//            color: 'blue',
//        },
//        content: {
//            fontSize: 15,
//            color: 'black',
//        }
//
//    })
//
//}