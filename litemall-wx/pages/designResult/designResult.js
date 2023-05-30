// pages/designResult/designResult.js
Page({

  data: {
    upload_pic:'/static/images/style1.png',
  },


  onLoad: function (options) {
    // var pic=wx.getStorageSync('key1')
    // this.setData({
    //   upload_pic:pic
    // })

  },

  toSave:function(){
    wx.navigateTo({
      url: 'url',
    })
  },

  toOrder:function(){
    wx.navigateTo({
      url: '/pages/goodList/goodList',
    })
  },
  

})